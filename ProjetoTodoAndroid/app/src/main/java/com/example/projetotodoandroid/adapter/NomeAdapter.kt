package com.example.projetotodoandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetotodoandroid.MainViewModel
import com.example.projetotodoandroid.R
import com.example.projetotodoandroid.databinding.CardLayoutBinding
import com.example.projetotodoandroid.databinding.FragmentListBinding
import com.example.projetotodoandroid.model.Tarefa

class NomeAdapter (


    val taskClickListener: TaskClickListener,
    val mainViewModel: MainViewModel): RecyclerView.Adapter<NomeAdapter.NomeMyViewHolder>() {

    var listaTarefas = emptyList<Tarefa>()

    class NomeMyViewHolder(val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root){



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NomeMyViewHolder {


        return NomeMyViewHolder(CardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    override fun onBindViewHolder(holder: NomeMyViewHolder, position: Int) {

        val tarefa = listaTarefas[position]

        holder.binding.textNome.text = tarefa.nome
        holder.binding.textResponsavel.text = tarefa.responsavel
        holder.binding.textDescricao.text = tarefa.descrição
        holder.binding.textData.text = tarefa.data
        holder.binding.textCategoria.text = tarefa.categoria.descricao
        holder.binding.switch1.isChecked = tarefa.status
        holder.itemView.setOnClickListener{

            taskClickListener.onTaskClickListenter(tarefa)

        }

        holder.binding.switch1.setOnCheckedChangeListener { buttonView, ativo ->

               tarefa.status = ativo
            mainViewModel.updateTarefa(tarefa)

        }






    }

    override fun getItemCount(): Int {

        return listaTarefas.size

    }

    fun setLista(list: List<Tarefa>){

        listaTarefas = list.sortedByDescending { it.id }
         notifyDataSetChanged()
    }

}