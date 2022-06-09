package com.example.exercicodeviewmodelelivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exercicodeviewmodelelivedata.databinding.ActivityMainBinding

class MainActitivityViewModel : ViewModel() {



    var cont = MutableLiveData<Int>(0)


    fun addNum(){

        cont.value = cont.value?.plus(1)

    }
}