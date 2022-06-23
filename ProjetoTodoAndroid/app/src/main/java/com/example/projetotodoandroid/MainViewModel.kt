package com.example.projetotodoandroid

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetotodoandroid.model.Categoria
import com.example.projetotodoandroid.api.Repository
import com.example.projetotodoandroid.model.Tarefa
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

    private val repository : Repository
) :ViewModel() {

    var tarefaSelecionda : Tarefa? = null

    private var _myCategoryResponse = MutableLiveData<Response<List<Categoria>>>()

    val myCategoriaResponse : LiveData<Response<List<Categoria>>>
    = _myCategoryResponse

    val dataSelecionada = MutableLiveData<LocalDate>()

    private val _myTarefaResponde = MutableLiveData<Response<List<Tarefa>>>()

    val myTarefaResponse : LiveData<Response<List<Tarefa>>> = _myTarefaResponde


   fun listCategoria(){

       viewModelScope.launch() {

           try {

               val response = repository.listCategoria()

               _myCategoryResponse.value = response

           }catch (e: Exception){

               Log.d("Erro", e.message.toString())



           }




       }


   }

    fun addTarefa(tarefa: Tarefa){

        viewModelScope.launch{


            try {

                val response = repository.addTarefa(tarefa)
                Log.d("Opa",  response.body().toString() )
                listTarefa()

                listTarefa()

            }catch (e : Exception){
             Log.d("Erro", e.message.toString())

            }

        }

    }

    fun listTarefa(){
        viewModelScope.launch {

            try {


                val response = repository.listTarefa()
               _myTarefaResponde.value = response



            }catch (e : Exception){

                Log.d("Erro", e.message.toString())



            }

        }

    }

    fun updateTarefa(tarefa: Tarefa){

        viewModelScope.launch {


            try {

                repository.updateTarefa(tarefa)
                listTarefa()

            }catch (e : Exception){
                Log.d("Erro", e.message.toString())

            }

        }


    }


}