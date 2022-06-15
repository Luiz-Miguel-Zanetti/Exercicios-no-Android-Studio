package com.example.projetotodoandroid.model

 data class Tarefa(
     val id: Long,
     val nome:String, val descrição: String, val responsavel: String, val data: String,
     val status: Boolean, val categoria: Categoria
 ) {




}