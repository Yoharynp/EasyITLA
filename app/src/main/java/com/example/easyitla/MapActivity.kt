package com.example.easyitla

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions
import com.google.maps.DirectionsApi
import com.google.maps.GeoApiContext
import com.google.maps.android.PolyUtil
import com.google.maps.model.TravelMode


class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback

    companion object {
        const val LOCATION_PERMISSION_REQUEST_CODE = 1000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)


        mapView = findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)



        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                locationResult ?: return}}/*
                for (location in locationResult.locations) {
                    val latLng = LatLng(location.latitude, location.longitude)
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))
                }
            }
        }*/

                checkLocationPermission()
                requestPermissionLauncher

            }


            override fun onStart() {
                super.onStart()
                mapView.onStart()
                startLocationUpdates()
            }

            override fun onStop() {
                super.onStop()
                mapView.onStop()
                stopLocationUpdates()
            }

            private fun startLocationUpdates() {
                val locationRequest = LocationRequest.create()
                    .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                    .setInterval(5000)
                    .setFastestInterval(1000)
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return
                }
                fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null)
            }

            private fun stopLocationUpdates() {
                fusedLocationClient.removeLocationUpdates(locationCallback)
            }

            private fun checkLocationPermission() {
                if (ContextCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                        LOCATION_PERMISSION_REQUEST_CODE
                    )
                }
            }

            private fun requestLocationPermission() {
                if (ContextCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                        LOCATION_PERMISSION_REQUEST_CODE
                    )
                } else {
                    // Permiso ya concedido
                    enableMyLocation()
                }
            }


            override fun onRequestPermissionsResult(
                requestCode: Int,
                permissions: Array<out String>,
                grantResults: IntArray
            ) {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults)
                if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
                    if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED && permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION) {
                        // Permiso concedido
                        enableMyLocation()
                    } else {
                        // Permiso denegado
                        Toast.makeText(
                            this,
                            "No se concedieron los permisos necesarios",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }
            }

            private val requestPermissionLauncher =
                registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
                    if (isGranted) {
                        // Permiso concedido
                        enableMyLocation()
                    } else {
                        // Permiso denegado
                        Toast.makeText(
                            this,
                            "No se concedieron los permisos necesarios",

                            Toast.LENGTH_SHORT
                        ).show()
                        requestLocationPermission()
                    }
                }


            private fun enableMyLocation() {
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    googleMap.isMyLocationEnabled = true
                }
            }


            override fun onMapReady(googleMap: GoogleMap) {
                this.googleMap = googleMap

                if (ContextCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) == PermissionChecker.PERMISSION_GRANTED
                ) {
                    googleMap?.isMyLocationEnabled = true
                    googleMap?.uiSettings?.isMyLocationButtonEnabled = true

                    LocationServices.getFusedLocationProviderClient(this).lastLocation.addOnSuccessListener { location ->
                        if (location != null) {
                            val latLng = LatLng(location.latitude, location.longitude)
                            googleMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16f))

                            val busStop1 = LatLng(18.480474, -69.940342)
                            val busStop2 = LatLng(18.480637, -69.938989)

                            createRoute(latLng, busStop1)
                            createRoute(busStop1, busStop2)
                            createRoute(busStop2, latLng)

                            // Obtiene la ruta entre el origen y destino utilizando la API de direcciones
                            /*val directions = DirectionsApiRequest(geoApiContext)
                        .origin(origin.latitude.toString() + "," + origin.longitude.toString())
                        .destination(destination.latitude.toString() + "," + destination.longitude.toString())
                        .mode(TravelMode.DRIVING)
                        .await()



                    val points = ArrayList<LatLng>()
                    val legs = directions.routes[0].legs
                    for (i in 0 until legs.size) {
                        val steps = legs[i].steps
                        for (j in 0 until steps.size) {
                            val polyline = steps[j].polyline
                            val decodedPolyline = PolylineEncoding.decode(polyline.getEncodedPath())
                            for (k in 0 until decodedPolyline.size) {
                                points.add(LatLng(decodedPolyline[k].lat, decodedPolyline[k].lng))
                            }
                        }
                    }

                    val polylineOptions = PolylineOptions()
                    polylineOptions.addAll(points)
                    polylineOptions.width(10f)
                    polylineOptions.color(Color.RED)
                    googleMap.addPolyline(polylineOptions)

                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(origin, 12f))*/

                        }
                    }
                } else {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                        LOCATION_PERMISSION_REQUEST_CODE

                    )

                }


            }

            private fun createRoute(start: LatLng, end: LatLng) {
                val context = GeoApiContext.Builder()
                    .apiKey("your_api_key_here")
                    .build()

                val request = DirectionsApi.getDirections(
                    context,
                    "${start.latitude},${start.longitude}",
                    "${end.latitude},${end.longitude}"
                )
                    .mode(TravelMode.DRIVING)
                    .await()

                if (request.routes.isNotEmpty()) {
                    val route = request.routes[0]
                    val overviewPolyline = route.overviewPolyline
                    val points = PolyUtil.decode(overviewPolyline.encodedPath)

                    val options = PolylineOptions().apply {
                        color(Color.RED)
                        width(5f)
                        addAll(points)
                    }

                    googleMap.addPolyline(options)
                } else {
                    Log.e("MapActivity", "Failed to create route")
                }
            }

        }

