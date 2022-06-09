package com.example.exercicodeviewmodelelivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.exercicodeviewmodelelivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainActitivityViewModel: MainActitivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
               super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainActitivityViewModel = ViewModelProvider(this).get(MainActitivityViewModel::class.java)

        mainActitivityViewModel.cont.observe(this) {

            binding.textContagem.text = it.toString()

        }

        binding.button.setOnClickListener {

           mainActitivityViewModel.addNum()



        }

    }
}