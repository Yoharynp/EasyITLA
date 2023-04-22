package com.example.easyitla

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class ActivityNotify : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notify)

        val editText = findViewById<EditText>(R.id.editTextNumberSigned)
        val btnListo = findViewById<Button>(R.id.Listo)

        btnListo.setOnClickListener{
            val valor = editText.text.toString().trim()

            if (valor.isNotEmpty()){
                val builder = AlertDialog.Builder(this)
                builder.setMessage("Su peticion ha sido enviada correctamente \nEstaremos contactando con usted via email para informarle de su caso. \n¡Gracias!")
                builder.setPositiveButton("Aceptar") { _, _ ->
                    val intent = Intent(this@ActivityNotify, AuthActivity::class.java)
                    startActivity(intent)
                }
                    val dialog = builder.create()
                    dialog.show()


            }else{
                val builder = AlertDialog.Builder(this)
                builder.setMessage("!El campo esta vacio! \nIngrese su matricula por favor")
                builder.setPositiveButton("Aceptar") {_, _ ->

                }

                builder.show()
            }
        }

    }


}