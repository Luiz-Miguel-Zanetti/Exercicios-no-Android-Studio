package com.example.projetotodoandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetotodoandroid.adapter.NomeAdapter
import com.example.projetotodoandroid.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)



          val buttonAdd = view.findViewById<FloatingActionButton>(R.id.floatingAdd)
        buttonAdd.setOnClickListener {

            findNavController().navigate(R.id.action_listFragment2_to_formFragment2)

            val listaTarefas  = listOf(Tarefa(

                "Lavar a louça",
                "Lavar a louça o dia todo",
                "Luiz",
                "12/07/2022",
                true,
                "Dia a Dia"),

                Tarefa( "Lavar o carro",
                "Lavar o carro por fora",
                "Paulo",
                "12/07/2022",
                true,
                "Dia a Dia" ),

                Tarefa( "Levar o lixo para fora",
                    "Levar o lixo para fora",
                    "Rafael",
                    "15/07/2022",
                    true,
                    "Segunda e sexta" ),


                Tarefa( "Lavar a casa",
                    "Lavar a casa ",
                    "Paulo",
                    "12/07/2022",
                    true,
                    "Dia a Dia" ),

                Tarefa( "Lavar o carro",
                    "Lavar o carro por fora",
                    "Edgar",
                    "08/10/2022",
                    true,
                    "Dia a Dia" ),

                Tarefa( "Trocar a lampada",
                    "Trocar a lampada",
                    "José",
                    "12/07/2022",
                    true,
                    "Dia a Dia" ),

                Tarefa( "Passar o aspirador",
                "Passar o aspirador",
                "Graça",
                "05/06/2022",
                true,
                "Dia a Dia" ),

                Tarefa( "Pintar a casa",
                    "Lavar o carro por fora",
                    "Valdir",
                    "05/12/2022",
                    true,
                    "Dia a Dia" ),

                Tarefa( "Dar banho no cachorro",
                    "Lavar o carro por fora",
                    "Henrique",
                    "12/07/2022",
                    true,
                    "Dia a Dia" ),

                Tarefa( "Formatar o notebook",
                    "Formatar o notebook",
                    "Sidney",
                    "12/07/2022",
                    true,
                    "Dia a Dia" ),

                Tarefa( "Ir no médico",
                    "Ir no médico",
                    "Daniel",
                    "03/03/2022",
                    true,
                    "Dia a Dia" ),

                Tarefa( "Fazer comida",
                    "Fazer comida",
                    "Paula",
                    "12/07/2022",
                    true,
                    "Dia a Dia" ),

                Tarefa( "Comprar pão",
                    "Comprar pão",
                    "",
                    "12/07/2022",
                    true,
                    "Dia a Dia" ),
            )

            val reyclerTarefas : RecyclerView = view.findViewById(R.id.recyclerTarefa)

            val adapter = NomeAdapter()

            reyclerTarefas.adapter = adapter
            reyclerTarefas.layoutManager = LinearLayoutManager(context)
            reyclerTarefas.setHasFixedSize(true)
            adapter.setLista(listaTarefas)

        }

        return view
    }


}