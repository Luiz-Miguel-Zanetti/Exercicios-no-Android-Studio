package com.example.projetotodoandroid.api

import com.example.projetotodoandroid.model.Categoria
import com.example.projetotodoandroid.model.Tarefa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

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


}