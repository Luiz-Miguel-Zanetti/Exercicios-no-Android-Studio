package com.example.projetotodoandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetotodoandroid.R
import com.example.projetotodoandroid.model.Tarefa

class NomeAdapter : RecyclerView.Adapter<NomeAdapter.NomeMyViewHolder>() {

    var listaTarefas = emptyList<Tarefa>()

    class NomeMyViewHolder(view : View) : RecyclerView.ViewHolder(view){

        val nomeTarefa = view.findViewById<TextView>(R.id.textNome)
        val responsavel = view.findViewById<TextView>(R.id.textResponsavel)
        val descrição = view.findViewById<TextView>(R.id.textDescrição)
        val data = view.findViewById<TextView>(R.id.textData)
        val categoria = view.findViewById<TextView>(R.id.textCategoria)
        val switch = view.findViewById<TextView>(R.id.switch1)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NomeMyViewHolder {

       val layout = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)

        return NomeMyViewHolder(layout)

    }

    override fun onBindViewHolder(holder: NomeMyViewHolder, position: Int) {

        val item = listaTarefas[position]

        holder.nomeTarefa.text = item.nome
        holder.responsavel.text = item.responsavel
        holder.descrição.text = item.descrição
        holder.data.text = item.data
        holder.categoria.text = item.categoria.descrição






    }

    override fun getItemCount(): Int {

        return listaTarefas.size

    }

    fun setLista(list: List<Tarefa>){

        listaTarefas = list
         notifyDataSetChanged()
    }

}