package com.example.easyitla

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class ConfigurationActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuration)
        if (Environment.isExternalStorageManager()) {

            Sobreescribir()
        } else {
            // No se ha concedido permiso, solicitar al usuario
            val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
            intent.addCategory("android.intent.category.DEFAULT")
            intent.data = Uri.parse("package:" + packageName)
            startActivity(intent)
        }
        Personalizar()
        Atras()

    }


    private fun Personalizar(){
        val saltar = findViewById<Button>(R.id.btnSaveChanges)
        saltar.setOnClickListener {
            val intent = Intent(this, MainConfiPersonality::class.java)
            startActivity(intent)
        }
    }


    fun Sobreescribir() {

        val sharedPreferences = getSharedPreferences("Datos", Context.MODE_PRIVATE)
        val nombre = sharedPreferences.getString("nombre", "")
        val telefono = sharedPreferences.getString("telefono", "")
        val imagen = sharedPreferences.getString("foto", "")
        findViewById<EditText>(R.id.CambioName).setText(nombre)
        findViewById<EditText>(R.id.CambioPhone).setText(telefono)


        val imageUri = Uri.parse(imagen)
        if (imageUri != null){
            findViewById<ImageView>(R.id.ViewChange).setImageURI(imageUri)
        }else{
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable._0220113_012508)
            val miImagen: Bitmap = bitmap
            val imageView = findViewById<ImageView>(R.id.ViewChange)
            imageView.setImageBitmap(miImagen)

        }


    }


    private fun Atras(){
        val atras = findViewById<Button>(R.id.btnback)
        atras.setOnClickListener {
            val inten = Intent(this, HomeActivity::class.java)
            startActivity(inten)
        }
    }


}