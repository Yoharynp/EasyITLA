package com.example.easyitla

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.maps.DirectionsApiRequest
import com.google.maps.model.TravelMode

enum class ProviderType{
    BASIC
}
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        LogOut()
        AbrirConfig()
        AbrirRecarga()
        monedero()
        AbrirReservar()
        AbrirLocacion()

    }

    private fun AbrirConfig(){
        val open = findViewById<Button>(R.id.btnconfig)
        open.setOnClickListener {
            val intent = Intent(this, ConfigurationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun LogOut(){
        val salir = findViewById<TextView>(R.id.Salir)

        salir.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }
    }

    private fun AbrirRecarga(){
        val open = findViewById<Button>(R.id.btnrecargar)
        open.setOnClickListener {
            val intent = Intent(this, MonederoActivity::class.java)
            startActivity(intent)
        }
    }


    fun monedero(){
        val sharedPreferences = getSharedPreferences("Monedero", Context.MODE_PRIVATE)
        var Monedero = sharedPreferences.getString("Total", "").toString()
        findViewById<TextView>(R.id.edittextmonedero).setText("RD$${Monedero}")

    }

    private fun AbrirReservar(){
        val abrir = findViewById<Button>(R.id.btnreservar)
        abrir.setOnClickListener {
            val inten = Intent(this, ReservarActivity::class.java)
            startActivity(inten)
        }
    }

    private fun AbrirLocacion(){
        val avrir = findViewById<Button>(R.id.btnLocacion)
        avrir.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
    }



}