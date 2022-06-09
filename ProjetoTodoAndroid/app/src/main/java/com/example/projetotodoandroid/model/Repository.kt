package com.example.projetotodoandroid.model

import com.example.projetotodoandroid.api.RetrofitInstance
import retrofit2.Response

class Repository {

  suspend fun listCategoria() : Response<List<Categoria>>{

         return RetrofitInstance.api.listCategoria()


    }

}