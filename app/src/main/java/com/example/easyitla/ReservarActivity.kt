package com.example.easyitla

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class ReservarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservar)

        Desactivar()
    }

    private fun Desactivar(){
        val iz1 = findViewById<Switch>(R.id.swichtizq1)
        val iz2 = findViewById<Switch>(R.id.switchizq2)
        val iz3 = findViewById<Switch>(R.id.switchizq3)
        val iz4 = findViewById<Switch>(R.id.switchizq4)
        val iz5 = findViewById<Switch>(R.id.switchizq5)
        val iz6 = findViewById<Switch>(R.id.switchizq6)
        val iz7 = findViewById<Switch>(R.id.switchizq7)
        val iz8 = findViewById<Switch>(R.id.switchizq8)
        val der1 = findViewById<Switch>(R.id.switchder1)
        val der2 = findViewById<Switch>(R.id.switchder2)
        val der3 = findViewById<Switch>(R.id.switchder3)
        val der4 = findViewById<Switch>(R.id.switchder4)
        val der5 = findViewById<Switch>(R.id.switchder5)
        val der6 = findViewById<Switch>(R.id.switchder6)
        val der7 = findViewById<Switch>(R.id.switchder7)
        val der8 = findViewById<Switch>(R.id.switchder8)

        iz1.setOnCheckedChangeListener { _, isCheked ->
            if (isCheked) {
                Toast.makeText(this, "Deslice para seleccionar opciones", Toast.LENGTH_SHORT).show()
                showSelectionDialog()
                iz2.isEnabled = false
                iz3.isEnabled = false
                iz4.isEnabled = false
                iz5.isEnabled = false
                iz6.isEnabled = false
                iz7.isEnabled = false
                iz8.isEnabled = false
                der1.isEnabled = false
                der2.isEnabled = false
                der3.isEnabled = false
                der4.isEnabled = false
                der5.isEnabled = false
                der6.isEnabled = false
                der7.isEnabled = false
                der8.isEnabled = false
            } else {
                Toast.makeText(this, "Adiós!", Toast.LENGTH_SHORT).show()

                iz2.isEnabled = true
                iz3.isEnabled = true
                iz4.isEnabled = true
                iz5.isEnabled = true
                iz6.isEnabled = true
                iz7.isEnabled = true
                iz8.isEnabled = true
                der1.isEnabled = true
                der2.isEnabled = true
                der3.isEnabled = true
                der4.isEnabled = true
                der5.isEnabled = true
                der6.isEnabled = true
                der7.isEnabled = true
                der8.isEnabled = true
            }
        }
        iz2.setOnCheckedChangeListener { _, isCheked ->
            if (isCheked) {
                Toast.makeText(this, "Deslice para seleccionar opciones", Toast.LENGTH_SHORT).show()
                showSelectionDialog()
                iz1.isEnabled = false
                iz3.isEnabled = false
                iz4.isEnabled = false
                iz5.isEnabled = false
                iz6.isEnabled = false
                iz7.isEnabled = false
                iz8.isEnabled = false
                der1.isEnabled = false
                der2.isEnabled = false
                der3.isEnabled = false
                der4.isEnabled = false
                der5.isEnabled = false
                der6.isEnabled = false
                der7.isEnabled = false
                der8.isEnabled = false
            } else {
                iz1.isEnabled = true
                iz3.isEnabled = true
                iz4.isEnabled = true
                iz5.isEnabled = true
                iz6.isEnabled = true
                iz7.isEnabled = true
                iz8.isEnabled = true
                der1.isEnabled = true
                der2.isEnabled = true
                der3.isEnabled = true
                der4.isEnabled = true
                der5.isEnabled = true
                der6.isEnabled = true
                der7.isEnabled = true
                der8.isEnabled = true
            }
        }
        iz3.setOnCheckedChangeListener { _, isCheked ->
            if (isCheked) {
                Toast.makeText(this, "Deslice para seleccionar opciones", Toast.LENGTH_SHORT).show()
                showSelectionDialog()
                iz2.isEnabled = false
                iz1.isEnabled = false
                iz4.isEnabled = false
                iz5.isEnabled = false
                iz6.isEnabled = false
                iz7.isEnabled = false
                iz8.isEnabled = false
                der1.isEnabled = false
                der2.isEnabled = false
                der3.isEnabled = false
                der4.isEnabled = false
                der5.isEnabled = false
                der6.isEnabled = false
                der7.isEnabled = false
                der8.isEnabled = false
            } else {
                iz2.isEnabled = true
                iz1.isEnabled = true
                iz4.isEnabled = true
                iz5.isEnabled = true
                iz6.isEnabled = true
                iz7.isEnabled = true
                iz8.isEnabled = true
                der1.isEnabled = true
                der2.isEnabled = true
                der3.isEnabled = true
                der4.isEnabled = true
                der5.isEnabled = true
                der6.isEnabled = true
                der7.isEnabled = true
                der8.isEnabled = true
            }
        }
        iz4.setOnCheckedChangeListener { _, isCheked ->
            if (isCheked) {
                Toast.makeText(this, "Deslice para seleccionar opciones", Toast.LENGTH_SHORT).show()
                showSelectionDialog()
                iz2.isEnabled = false
                iz3.isEnabled = false
                iz1.isEnabled = false
                iz5.isEnabled = false
                iz6.isEnabled = false
                iz7.isEnabled = false
                iz8.isEnabled = false
                der1.isEnabled = false
                der2.isEnabled = false
                der3.isEnabled = false
                der4.isEnabled = false
                der5.isEnabled = false
                der6.isEnabled = false
                der7.isEnabled = false
                der8.isEnabled = false
            } else {
                iz2.isEnabled = true
                iz3.isEnabled = true
                iz1.isEnabled = true
                iz5.isEnabled = true
                iz6.isEnabled = true
                iz7.isEnabled = true
                iz8.isEnabled = true
                der1.isEnabled = true
                der2.isEnabled = true
                der3.isEnabled = true
                der4.isEnabled = true
                der5.isEnabled = true
                der6.isEnabled = true
                der7.isEnabled = true
                der8.isEnabled = true
            }
        }
        iz5.setOnCheckedChangeListener { _, isCheked ->
            if (isCheked) {
                Toast.makeText(this, "Deslice para seleccionar opciones", Toast.LENGTH_SHORT).show()
                showSelectionDialog()
                iz2.isEnabled = false
                iz3.isEnabled = false
                iz4.isEnabled = false
                iz1.isEnabled = false
                iz6.isEnabled = false
                iz7.isEnabled = false
                iz8.isEnabled = false
                der1.isEnabled = false
                der2.isEnabled = false
                der3.isEnabled = false
                der4.isEnabled = false
                der5.isEnabled = false
                der6.isEnabled = false
                der7.isEnabled = false
                der8.isEnabled = false
            } else {
                iz2.isEnabled = true
                iz3.isEnabled = true
                iz4.isEnabled = true
                iz1.isEnabled = true
                iz6.isEnabled = true
                iz7.isEnabled = true
                iz8.isEnabled = true
                der1.isEnabled = true
                der2.isEnabled = true
                der3.isEnabled = true
                der4.isEnabled = true
                der5.isEnabled = true
                der6.isEnabled = true
                der7.isEnabled = true
                der8.isEnabled = true
            }
        }
        iz6.setOnCheckedChangeListener { _, isCheked ->
            if (isCheked) {
                Toast.makeText(this, "Deslice para seleccionar opciones", Toast.LENGTH_SHORT).show()
                showSelectionDialog()
                iz2.isEnabled = false
                iz3.isEnabled = false
                iz4.isEnabled = false
                iz5.isEnabled = false
                iz1.isEnabled = false
                iz7.isEnabled = false
                iz8.isEnabled = false
                der1.isEnabled = false
                der2.isEnabled = false
                der3.isEnabled = false
                der4.isEnabled = false
                der5.isEnabled = false
                der6.isEnabled = false
                der7.isEnabled = false
                der8.isEnabled = false
            } else {
                iz2.isEnabled = true
                iz3.isEnabled = true
                iz4.isEnabled = true
                iz5.isEnabled = true
                iz1.isEnabled = true
                iz7.isEnabled = true
                iz8.isEnabled = true
                der1.isEnabled = true
                der2.isEnabled = true
                der3.isEnabled = true
                der4.isEnabled = true
                der5.isEnabled = true
                der6.isEnabled = true
                der7.isEnabled = true
                der8.isEnabled = true
            }
        }
        iz7.setOnCheckedChangeListener { _, isCheked ->
            if (isCheked) {
                Toast.makeText(this, "Deslice para seleccionar opciones", Toast.LENGTH_SHORT).show()
                showSelectionDialog()
                iz2.isEnabled = false
                iz3.isEnabled = false
                iz4.isEnabled = false
                iz5.isEnabled = false
                iz6.isEnabled = false
                iz1.isEnabled = false
                iz8.isEnabled = false
                der1.isEnabled = false
                der2.isEnabled = false
                der3.isEnabled = false
                der4.isEnabled = false
                der5.isEnabled = false
                der6.isEnabled = false
                der7.isEnabled = false
                der8.isEnabled = false
            } else {
                iz2.isEnabled = true
                iz3.isEnabled = true
                iz4.isEnabled = true
                iz5.isEnabled = true
                iz6.isEnabled = true
                iz1.isEnabled = true
                iz8.isEnabled = true
                der1.isEnabled = true
                der2.isEnabled = true
                der3.isEnabled = true
                der4.isEnabled = true
                der5.isEnabled = true
                der6.isEnabled = true
                der7.isEnabled = true
                der8.isEnabled = true
            }
        }
        iz8.setOnCheckedChangeListener { _, isCheked ->
            if (isCheked) {
                Toast.makeText(this, "Deslice para seleccionar opciones", Toast.LENGTH_SHORT).show()
                showSelectionDialog()
                iz2.isEnabled = false
                iz3.isEnabled = false
                iz4.isEnabled = false
                iz5.isEnabled = false
                iz6.isEnabled = false
                iz7.isEnabled = false
                iz1.isEnabled = false
                der1.isEnabled = false
                der2.isEnabled = false
                der3.isEnabled = false
                der4.isEnabled = false
                der5.isEnabled = false
                der6.isEnabled = false
                der7.isEnabled = false
                der8.isEnabled = false
            } else {
                iz2.isEnabled = true
                iz3.isEnabled = true
                iz4.isEnabled = true
                iz5.isEnabled = true
                iz6.isEnabled = true
                iz7.isEnabled = true
                iz1.isEnabled = true
                der1.isEnabled = true
                der2.isEnabled = true
                der3.isEnabled = true
                der4.isEnabled = true
                der5.isEnabled = true
                der6.isEnabled = true
                der7.isEnabled = true
                der8.isEnabled = true

            }
        }

        der1.setOnCheckedChangeListener { _, isCheked ->
            if (isCheked) {
                Toast.makeText(this, "Deslice para seleccionar opciones", Toast.LENGTH_SHORT).show()
                showSelectionDialog()
                der2.isEnabled = false
                der3.isEnabled = false
                der4.isEnabled = false
                der5.isEnabled = false
                der6.isEnabled = false
                der7.isEnabled = false
                der8.isEnabled = false
                iz1.isEnabled = false
                iz2.isEnabled = false
                iz3.isEnabled = false
                iz4.isEnabled = false
                iz5.isEnabled = false
                iz6.isEnabled = false
                iz7.isEnabled = false
                iz8.isEnabled = false
            } else {

                der2.isEnabled = true
                der3.isEnabled = true
                der4.isEnabled = true
                der5.isEnabled = true
                der6.isEnabled = true
                der7.isEnabled = true
                der8.isEnabled = true
                iz1.isEnabled = true
                iz2.isEnabled = true
                iz3.isEnabled = true
                iz4.isEnabled = true
                iz5.isEnabled = true
                iz6.isEnabled = true
                iz7.isEnabled = true
                iz8.isEnabled = true
            }
        }
        der2.setOnCheckedChangeListener { _, isCheked ->
            if (isCheked) {
                Toast.makeText(this, "Deslice para seleccionar opciones", Toast.LENGTH_SHORT).show()
                showSelectionDialog()
                der1.isEnabled = false
                der3.isEnabled = false
                der4.isEnabled = false
                der5.isEnabled = false
                der6.isEnabled = false
                der7.isEnabled = false
                der8.isEnabled = false
                iz1.isEnabled = false
                iz2.isEnabled = false
                iz3.isEnabled = false
                iz4.isEnabled = false
                iz5.isEnabled = false
                iz6.isEnabled = false
                iz7.isEnabled = false
                iz8.isEnabled = false
            } else {
                der1.isEnabled = true
                der3.isEnabled = true
                der4.isEnabled = true
                der5.isEnabled = true
                der6.isEnabled = true
                der7.isEnabled = true
                der8.isEnabled = true
                iz1.isEnabled = true
                iz2.isEnabled = true
                iz3.isEnabled = true
                iz4.isEnabled = true
                iz5.isEnabled = true
                iz6.isEnabled = true
                iz7.isEnabled = true
                iz8.isEnabled = true
            }
        }
        der3.setOnCheckedChangeListener { _, isCheked ->
            if (isCheked) {
                Toast.makeText(this, "Deslice para seleccionar opciones", Toast.LENGTH_SHORT).show()
                showSelectionDialog()
                der2.isEnabled = false
                der1.isEnabled = false
                der4.isEnabled = false
                der5.isEnabled = false
                der6.isEnabled = false
                der7.isEnabled = false
                der8.isEnabled = false
                iz1.isEnabled = false
                iz2.isEnabled = false
                iz3.isEnabled = false
                iz4.isEnabled = false
                iz5.isEnabled = false
                iz6.isEnabled = false
                iz7.isEnabled = false
                iz8.isEnabled = false
            } else {
                der2.isEnabled = true
                der1.isEnabled = true
                der4.isEnabled = true
                der5.isEnabled = true
                der6.isEnabled = true
                der7.isEnabled = true
                der8.isEnabled = true
                iz1.isEnabled = true
                iz2.isEnabled = true
                iz3.isEnabled = true
                iz4.isEnabled = true
                iz5.isEnabled = true
                iz6.isEnabled = true
                iz7.isEnabled = true
                iz8.isEnabled = true
            }
        }
        der4.setOnCheckedChangeListener { _, isCheked ->
            if (isCheked) {
                Toast.makeText(this, "Deslice para seleccionar opciones", Toast.LENGTH_SHORT).show()
                showSelectionDialog()
                der2.isEnabled = false
                der3.isEnabled = false
                der1.isEnabled = false
                der5.isEnabled = false
                der6.isEnabled = false
                der7.isEnabled = false
                der8.isEnabled = false
                iz1.isEnabled = false
                iz2.isEnabled = false
                iz3.isEnabled = false
                iz4.isEnabled = false
                iz5.isEnabled = false
                iz6.isEnabled = false
                iz7.isEnabled = false
                iz8.isEnabled = false
            } else {
                der2.isEnabled = true
                der3.isEnabled = true
                der1.isEnabled = true
                der5.isEnabled = true
                der6.isEnabled = true
                der7.isEnabled = true
                der8.isEnabled = true
                iz1.isEnabled = true
                iz2.isEnabled = true
                iz3.isEnabled = true
                iz4.isEnabled = true
                iz5.isEnabled = true
                iz6.isEnabled = true
                iz7.isEnabled = true
                iz8.isEnabled = true
            }
        }
        der5.setOnCheckedChangeListener { _, isCheked ->
            if (isCheked) {
                Toast.makeText(this, "Deslice para seleccionar opciones", Toast.LENGTH_SHORT).show()
                showSelectionDialog()
                der2.isEnabled = false
                der3.isEnabled = false
                der4.isEnabled = false
                der1.isEnabled = false
                der6.isEnabled = false
                der7.isEnabled = false
                der8.isEnabled = false
                iz1.isEnabled = false
                iz2.isEnabled = false
                iz3.isEnabled = false
                iz4.isEnabled = false
                iz5.isEnabled = false
                iz6.isEnabled = false
                iz7.isEnabled = false
                iz8.isEnabled = false
            } else {
                der2.isEnabled = true
                der3.isEnabled = true
                der4.isEnabled = true
                der1.isEnabled = true
                der6.isEnabled = true
                der7.isEnabled = true
                der8.isEnabled = true
                iz1.isEnabled = true
                iz2.isEnabled = true
                iz3.isEnabled = true
                iz4.isEnabled = true
                iz5.isEnabled = true
                iz6.isEnabled = true
                iz7.isEnabled = true
                iz8.isEnabled = true
            }
        }
        der6.setOnCheckedChangeListener { _, isCheked ->
            if (isCheked) {
                Toast.makeText(this, "Deslice para seleccionar opciones", Toast.LENGTH_SHORT).show()
                showSelectionDialog()
                der2.isEnabled = false
                der3.isEnabled = false
                der4.isEnabled = false
                der5.isEnabled = false
                der1.isEnabled = false
                der7.isEnabled = false
                der8.isEnabled = false
                iz1.isEnabled = false
                iz2.isEnabled = false
                iz3.isEnabled = false
                iz4.isEnabled = false
                iz5.isEnabled = false
                iz6.isEnabled = false
                iz7.isEnabled = false
                iz8.isEnabled = false
            } else {
                der2.isEnabled = true
                der3.isEnabled = true
                der4.isEnabled = true
                der5.isEnabled = true
                der1.isEnabled = true
                der7.isEnabled = true
                der8.isEnabled = true
                iz1.isEnabled = true
                iz2.isEnabled = true
                iz3.isEnabled = true
                iz4.isEnabled = true
                iz5.isEnabled = true
                iz6.isEnabled = true
                iz7.isEnabled = true
                iz8.isEnabled = true
            }
        }
        der7.setOnCheckedChangeListener { _, isCheked ->
            if (isCheked) {
                Toast.makeText(this, "Deslice para seleccionar opciones", Toast.LENGTH_SHORT).show()
                showSelectionDialog()
                der2.isEnabled = false
                der3.isEnabled = false
                der4.isEnabled = false
                der5.isEnabled = false
                der6.isEnabled = false
                der1.isEnabled = false
                der8.isEnabled = false
                iz1.isEnabled = false
                iz2.isEnabled = false
                iz3.isEnabled = false
                iz4.isEnabled = false
                iz5.isEnabled = false
                iz6.isEnabled = false
                iz7.isEnabled = false
                iz8.isEnabled = false
            } else {
                der2.isEnabled = true
                der3.isEnabled = true
                der4.isEnabled = true
                der5.isEnabled = true
                der6.isEnabled = true
                der1.isEnabled = true
                der8.isEnabled = true
                iz1.isEnabled = true
                iz2.isEnabled = true
                iz3.isEnabled = true
                iz4.isEnabled = true
                iz5.isEnabled = true
                iz6.isEnabled = true
                iz7.isEnabled = true
                iz8.isEnabled = true
            }
        }
        der8.setOnCheckedChangeListener { _, isCheked ->
            if (isCheked) {
                Toast.makeText(this, "Deslice para seleccionar opciones", Toast.LENGTH_SHORT).show()
                showSelectionDialog()
                der2.isEnabled = false
                der3.isEnabled = false
                der4.isEnabled = false
                der5.isEnabled = false
                der6.isEnabled = false
                der7.isEnabled = false
                der1.isEnabled = false
                iz1.isEnabled = false
                iz2.isEnabled = false
                iz3.isEnabled = false
                iz4.isEnabled = false
                iz5.isEnabled = false
                iz6.isEnabled = false
                iz7.isEnabled = false
                iz8.isEnabled = false
            } else {
                der2.isEnabled = true
                der3.isEnabled = true
                der4.isEnabled = true
                der5.isEnabled = true
                der6.isEnabled = true
                der7.isEnabled = true
                der1.isEnabled = true
                iz1.isEnabled = true
                iz2.isEnabled = true
                iz3.isEnabled = true
                iz4.isEnabled = true
                iz5.isEnabled = true
                iz6.isEnabled = true
                iz7.isEnabled = true
                iz8.isEnabled = true
            }
        }
    }

    fun showSelectionDialog() {
        val options = arrayOf("Salida", "Entrada")
        var selected = -1

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Seleccione para que quiere reservar")
        builder.setSingleChoiceItems(options, selected) { _, which ->
            selected = which
        }
        builder.setPositiveButton("OK") { dialog, _ ->
            if (selected >= 0) {
                Toast.makeText(this, "Opción seleccionada: ${options[selected]}", Toast.LENGTH_SHORT).show()
                showSelectionDialog2()
            }
            dialog.dismiss()
        }
        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }

    fun showSelectionDialog2() {
        val options = arrayOf("Villa Mella a Caleta", "Maximo Gomez Caleta", "Pinturas a Caleta")
        var selected = -1

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Seleccione Ruta")
        builder.setSingleChoiceItems(options, selected) { _, which ->
            selected = which
        }
        builder.setPositiveButton("OK") { dialog, _ ->
            if (selected >= 0) {
                Toast.makeText(this, "Opción seleccionada: ${options[selected]}", Toast.LENGTH_SHORT).show()
                showDatePickerDialog()
            }
            dialog.dismiss()
        }
        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }
    fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, year, month, dayOfMonth ->
            val selectedDate = "$dayOfMonth/${month + 1}/$year"
            Toast.makeText(this, "Fecha seleccionada: $selectedDate", Toast.LENGTH_SHORT).show()
            Monedero()
            val inte = Intent(this, HomeActivity::class.java)
            startActivity(inte)
        }, year, month, day)

        datePickerDialog.show()
    }
    private fun Monedero() {
        val layout = layoutInflater.inflate(R.layout.activity_home, null)
        val textView = layout.findViewById<TextView>(R.id.edittextmonedero)

        var cantidadActual = textView.text.substring(3).toInt()
        var cantidadNueva = 25
        var cantidadTotal = 100 + cantidadActual - cantidadNueva
        textView.text = "RD$${cantidadTotal}"
        var sharedPreferences = getSharedPreferences("Monedero", Context.MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        editor.putString("Total", cantidadTotal.toString())
        editor.apply()

    }
}