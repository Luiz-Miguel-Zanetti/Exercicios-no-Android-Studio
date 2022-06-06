package com.example.exercicionavegaoentreactivitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val buttonSalvar = findViewById<Button>( R.id.buttonSalvar )
        buttonSalvar.setOnClickListener {

            finish()

        }



    }
}