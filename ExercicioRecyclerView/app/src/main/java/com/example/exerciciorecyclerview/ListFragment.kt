package com.example.exerciciorecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exerciciorecyclerview.R
import com.example.exerciciorecyclerview.adapter.TarefaAdapter
import com.example.exerciciorecyclerview.databinding.FragmentListBinding
import com.example.exerciciorecyclerview.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

   private lateinit var binding : FragmentListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(layoutInflater, container, false )


            val lista = listOf(Tarefa(

                "Ir ao cinema",
                "Assistir Doutor Estranho",
                "Luiz",
                "01/02/2022",
                true,
                "Lazer",


            ),

                Tarefa(

                    "Lavar a casa",
                    "Limpar todos os comodos da casa",
                    "Familia",
                    "10/04/2022",
                    true,
                    "Limpeza",


                    ),

                Tarefa(

                    "Ir ao Parque",
                    "Ir ao parque Bosque maia com os amigos",
                    "Rafael",
                    "12/04/2022",
                    true,
                    "Diversão",


                    ),

                Tarefa(

                    "Tarefa escolar",
                    "Fazer a lição de casa",
                    "Thais",
                    "21/10/2022",
                    true,
                    "Dever",


                    ))

        binding.floatingAdd.setOnClickListener {

            findNavController().navigate(R.id.action_listFragment_to_formFragment2)


            val adapter = TarefaAdapter()
            binding.recyclerTarefa.adapter = adapter
            binding.recyclerTarefa.setHasFixedSize(true)
            binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)

            
            adapter.setLista(lista)


        }

        return binding.root

    }
}