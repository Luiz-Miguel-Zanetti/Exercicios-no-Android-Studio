package com.example.projetodado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dado)

        val buttonS20 = findViewById<Button>(R.id.buttonS20)
        buttonS20.setOnClickListener {

            sortearNumero(20)

        }

        val buttonD6 = findViewById<Button>(R.id.buttonD6)
        buttonD6.setOnClickListener {

            sortearDado(6)


        }

        val buttond12 = findViewById<Button>(R.id.buttonD12)
        buttond12.setOnClickListener {

            sortearDado(12)


        }

    }

    fun sortearDado(lados : Int){

        val sortear = (1..lados).random()

        val imagemDado = findViewById<ImageView>(R.id.imageDado)

        when( sortear ){

            1 -> imagemDado.setImageResource(R.drawable.dado1)
            2 -> imagemDado.setImageResource(R.drawable.dado2)
            3 -> imagemDado.setImageResource(R.drawable.dado3)
            4 -> imagemDado.setImageResource(R.drawable.dado4)
            5 -> imagemDado.setImageResource(R.drawable.dado5)
            6 -> imagemDado.setImageResource(R.drawable.dado6)
            7 -> imagemDado.setImageResource(R.drawable.dado7)
            9 -> imagemDado.setImageResource(R.drawable.dado8)
            10 -> imagemDado.setImageResource(R.drawable.dado10)
            11-> imagemDado.setImageResource(R.drawable.dado11)
            12-> imagemDado.setImageResource(R.drawable.dado12)


        }



    }

    fun sortearNumero(sortar: Int){

        val rolagem = (1..20).random()

        val textoSorteado = findViewById<TextView>(R.id.textoSortear)
        textoSorteado.text = rolagem.toString()

    }

}

