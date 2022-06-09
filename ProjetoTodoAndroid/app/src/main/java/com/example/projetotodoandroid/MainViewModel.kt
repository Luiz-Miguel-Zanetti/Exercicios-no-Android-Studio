package com.example.projetotodoandroid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetotodoandroid.model.Categoria
import com.example.projetotodoandroid.model.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel : ViewModel() {

    var repository = Repository()

    private var _myCategoryResponse = MutableLiveData<Response<List<Categoria>>>()

    val _myCategoriaResponse : LiveData<Response<List<Categoria>>>
    = _myCategoryResponse


   fun listCategoria(){

       viewModelScope.launch {

           _myCategoryResponse.value = repository.listCategoria()

       }


   }




}