package com.example.projetotodoandroid.api

import com.example.projetotodoandroid.model.Categoria
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("categoria")
    suspend fun listCategoria() : Response<List<Categoria>>


}