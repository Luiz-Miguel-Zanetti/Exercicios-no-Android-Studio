package com.example.projetotodoandroid.api

import com.example.projetotodoandroid.model.Categoria
import com.example.projetotodoandroid.model.Tarefa
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("categoria")
    suspend fun listCategoria() : Response<List<Categoria>>

    @POST("tarefa")
    suspend fun addTarefa(

        @Body tarefa: Tarefa) :Response<Tarefa>


    @GET("tarefa")
    suspend fun listTarefa() : Response<List<Tarefa>>

    @PUT("tarefas")
    suspend fun  updateTarefa(@Body tarefa: Tarefa) : Response<Tarefa>

    @DELETE("tarefas / {id}")
    suspend fun deleteTarefa(@Path ("id")  id : Long ) : Response<Tarefa>


}