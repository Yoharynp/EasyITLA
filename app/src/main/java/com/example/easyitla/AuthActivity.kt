package com.example.easyitla

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val textView = findViewById<TextView>(R.id.linkayuda)

        textView.setOnClickListener {
            val intent = Intent(this@AuthActivity, ActivityNotify::class.java)
            startActivity(intent)
        }
        val ingresar = findViewById<Button>(R.id.ingresar)
        Acceder()

    }

    private fun Acceder(){
        title = "Autenticacion"

        val btningresar = findViewById<Button>(R.id.ingresar)
        val email = findViewById<TextView>(R.id.editTextTextEmailAddress)
        val password =  findViewById<TextView>(R.id.editTextTextPassword)
        btningresar.setOnClickListener {
            if (email.text.isNotEmpty() && password.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email.text.toString(),password.text.toString()).addOnCompleteListener{
                    if (it.isSuccessful){
                        showHome(it.result?.user?.email?:"", ProviderType.BASIC)
                    }else{
                        Alert()
                    }
                }
            }
        }
    }

        private fun Alert(){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Error")
            builder.setMessage("Se ha producido un error al autenticar")
            builder.setPositiveButton("Aceptar", null)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

    private fun showHome(email: String, provider: ProviderType){
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }

}

