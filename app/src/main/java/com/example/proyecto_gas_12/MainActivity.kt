package com.example.proyecto_gas_12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var text_correo: Text
    private lateinit var text_contraseña: Text
    private lateinit var boton_ingresar: Button
    private lateinit var boton_registrar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        //Definir el evento click sobre el boton de login
        btnLogin.setOnClickListener{
            val intento1= Intent(this, NavigationActivity::class.java)
            startActivity(intento1)

        }


    }
}
