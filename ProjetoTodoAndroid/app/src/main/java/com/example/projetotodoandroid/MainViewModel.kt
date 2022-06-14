package com.example.projetotodoandroid

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetotodoandroid.model.Categoria
import com.example.projetotodoandroid.model.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import retrofit2.Response
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

    private val repository : Repository ) :ViewModel() {

    private var _myCategoryResponse = MutableLiveData<Response<List<Categoria>>>()

    val _myCategoriaResponse : LiveData<Response<List<Categoria>>>
    = _myCategoryResponse

    val dataSelecionada = MutableLiveData<LocalDate>()



   fun listCategoria(){

       viewModelScope.launch(Dispatchers.IO) {

           try {

               val response = repository.listCategoria()

               _myCategoryResponse.value = response

           }catch (e: Exception){

               Log.d("Erro", e.message.toString())



           }




       }


   }


}