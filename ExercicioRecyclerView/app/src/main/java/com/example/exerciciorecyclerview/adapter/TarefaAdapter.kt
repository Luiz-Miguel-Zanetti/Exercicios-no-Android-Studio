package com.example.exerciciorecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exerciciorecyclerview.databinding.CardLayoutBinding
import com.example.exerciciorecyclerview.databinding.FragmentFormBinding
import com.example.exerciciorecyclerview.model.Tarefa

class TarefaAdapter : RecyclerView.Adapter<TarefaAdapter.MyViewHolder>() {


    class MyViewHolder(val binding: CardLayoutBinding ) : RecyclerView.ViewHolder(binding.root)


    private var listaTarefa = emptyList<Tarefa>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(CardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var tarefa = listaTarefa[position]

        holder.binding.textNome.text = tarefa.nome
        holder.binding.textDescricao.text = tarefa.descrição
        holder.binding.textResponsavel.text = tarefa.responsavel
        holder.binding.textData.text = tarefa.data
        holder.binding.switchAtivo.isChecked = tarefa.status
        holder.binding.textCategoria.text = tarefa.categoria


    }

    override fun getItemCount(): Int {

        return listaTarefa.size

    }

    fun setLista(lista : List<Tarefa>){

        listaTarefa = lista
        notifyDataSetChanged()

    }

}