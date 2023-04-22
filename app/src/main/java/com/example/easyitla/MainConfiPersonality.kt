package com.example.easyitla

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainConfiPersonality : AppCompatActivity() {

    companion object {
        private const val REQUEST_PERMISSIONS = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_confi_personality)

        BorrarAlSeleccionar()
        val save = findViewById<Button>(R.id.btnSaveChanges)
        save.setOnClickListener {
            GuardarCambios()
        }
        selectImageFromGallery()


    }


    private fun BorrarAlSeleccionar() {
        val name = findViewById<EditText>(R.id.editTextTextPersonName)
        val email = findViewById<EditText>(R.id.editTextTextPersonemail)
        val number = findViewById<EditText>(R.id.editTextPhone)

        name.onFocusChangeListener = View.OnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                name.setText("")
            }
        }

        email.onFocusChangeListener = View.OnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                val build = AlertDialog.Builder(this)
                build.setMessage("El email no es editable.")
                build.setPositiveButton("De acuerdo", null)
                build.show()
                if (email.isEnabled) {
                    email.isEnabled = false
                }
            }
        }

        number.onFocusChangeListener = View.OnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                number.setText("")
            }
        }
    }

    private var selectedImageUri: Uri? = null

    @RequiresApi(Build.VERSION_CODES.R)
    private fun GuardarCambios() {
        val name = findViewById<EditText>(R.id.editTextTextPersonName)
                val telefono = findViewById<EditText>(R.id.editTextPhone)
                val nombre = name.text.toString()
                val phone = telefono.text.toString()
                val sharedPreferences = getSharedPreferences("Datos", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("nombre", nombre)
                editor.putString("telefono", phone)
                editor.putString("foto", selectedImageUri.toString())
                editor.apply()

                val intent = Intent(this, ConfigurationActivity::class.java)
                startActivity(intent)

    }

    private fun selectImageFromGallery() {
    val change = findViewById<ImageView>(R.id.ViewChange)
    change.setOnClickListener{
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        resultLauncher.launch(intent)
        }
    }

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data: Intent? = result.data
            selectedImageUri = result.data?.data
            val change = findViewById<ImageView>(R.id.ViewChange)
            change.setImageURI(selectedImageUri)
        }
    }

    @RequiresApi(Build.VERSION_CODES.R)
    fun Guardarpreferences(){
        if (Environment.isExternalStorageManager()) {

        } else {
            // No se ha concedido permiso, solicitar al usuario
            val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
            intent.addCategory("android.intent.category.DEFAULT")
            intent.data = Uri.parse("package:" + packageName)
            startActivity(intent)
        }
    }

}
