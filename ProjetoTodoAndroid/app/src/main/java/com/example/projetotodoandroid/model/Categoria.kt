package com.example.projetotodoandroid.model

data class Categoria( var id: Long, var descrição : String, var tarefa: List<Tarefa>  ) {
}