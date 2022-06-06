package com.example.exercicionavegaoentreactivitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            val buttonSalvar = findViewById<FloatingActionButton>( R.id.floatingAdd )
        buttonSalvar.setOnClickListener {

            val intenção = Intent(  this, FormActivity:: class.java )
            startActivity(intenção)

        }

    }
}