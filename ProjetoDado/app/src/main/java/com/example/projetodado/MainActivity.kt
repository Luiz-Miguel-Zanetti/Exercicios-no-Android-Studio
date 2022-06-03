package com.example.projetodado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        irTelaDadoActivity()


    }

    fun irTelaDadoActivity(){

        val botaoEntrar = findViewById<Button>(R.id.buttonEntrar)
        botaoEntrar.setOnClickListener{

            val intent = Intent(this, DadoActivity::class.java)
            startActivity(intent)

        }




    }

}