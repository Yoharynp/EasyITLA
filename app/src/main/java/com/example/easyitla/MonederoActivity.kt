package com.example.easyitla

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import android.text.Spanned
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MonederoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monedero)
        Grupos()
        Monedero()
        Fiao()
        val isFiaoDisabled = sharedPref.getBoolean("isFiaoDisabled", false)
        if (isFiaoDisabled) {
            val boton = findViewById<RadioButton>(R.id.Fiao)
            boton.isEnabled = false
        }
        sharedPref.edit().remove("isFiaoDisabled").apply()
    }

    private val sharedPref by lazy { getSharedPreferences("MyPrefs", Context.MODE_PRIVATE) }
    private fun Grupos(){
        val text = findViewById<EditText>(R.id.IngresoDinero)
        text.filters = arrayOf(InputFilter.LengthFilter(3))
        val radioGroup = findViewById<RadioGroup>(R.id.GroupButton)
        var selectedRadioButton: RadioButton? = null


        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            selectedRadioButton?.isChecked = false
            val radioButton = findViewById<RadioButton>(checkedId)
            radioButton.isChecked = true
            selectedRadioButton = radioButton
        }
    }

    private fun Monedero(){
        val layout = layoutInflater.inflate(R.layout.activity_home, null)
        val textView = layout.findViewById<TextView>(R.id.edittextmonedero)
        val editText = findViewById<EditText>(R.id.IngresoDinero)

        val botonReservar = findViewById<Button>(R.id.btnrecargar)
        botonReservar.setOnClickListener {
            var cantidadActual = textView.text.toString().substring(3).toInt()
            var cantidadNueva = editText.text.toString().toInt()
            var cantidadTotal = cantidadActual + cantidadNueva
            textView.text = "RD$${cantidadTotal}"
            var sharedPreferences = getSharedPreferences("Monedero", Context.MODE_PRIVATE)
            var editor = sharedPreferences.edit()
            editor.putString("Total", cantidadTotal.toString())
            editor.apply()
            Saltar(cantidadTotal)

        }

    }

    private fun Saltar(cantidadTotal: Int){
        val build = AlertDialog.Builder(this)
        build.setMessage("Cantidad Agregada")
        build.setPositiveButton("Aceptar"){_,_ ->
            val inten = Intent(this, HomeActivity::class.java)
            startActivity(inten)
        }
        build.show()
    }

    private fun Fiao(){
        val radioGroup = findViewById<RadioGroup>(R.id.GroupButton)
        val editText = findViewById<EditText>(R.id.IngresoDinero)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = group.findViewById<RadioButton>(checkedId)
            val message = "Has seleccionado: ${radioButton.text}, el limite se rebaja a 100"
            if (radioButton.id == R.id.Fiao) {
                editText.setText("")
                editText.filters = arrayOf(InputFilter.LengthFilter(3), MaxValueInputFilter(100))
                editText.isEnabled = true
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                val boton = findViewById<RadioButton>(R.id.Fiao)
                boton.isEnabled = false
                sharedPref.edit().putBoolean("isFiaoDisabled", true).apply()
            } else {
                editText.filters = arrayOf(InputFilter.LengthFilter(3))
                editText.isEnabled = true


            }
        }
    }

    class MaxValueInputFilter(private val maxValue: Int) : InputFilter {
        override fun filter(
            source: CharSequence?,
            start: Int,
            end: Int,
            dest: Spanned?,
            dstart: Int,
            dend: Int
        ): CharSequence? {
            val input = dest.toString() + source.toString()
            val inputVal = input.toIntOrNull()
            if (inputVal != null && inputVal > maxValue) {
                return dest?.subSequence(dstart, dend)
            }
            return null
        }
    }

}