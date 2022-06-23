package com.example.projetotodoandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetotodoandroid.adapter.NomeAdapter
import com.example.projetotodoandroid.adapter.TaskClickListener
import com.example.projetotodoandroid.databinding.FragmentListBinding
import com.example.projetotodoandroid.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListFragment : Fragment(), TaskClickListener {

    private lateinit var binding: FragmentListBinding
    private val mainViewModel : MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        mainViewModel.listTarefa()


        val adapter = NomeAdapter(this, mainViewModel)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.setHasFixedSize(true)



        binding.fabAdd.setOnClickListener {

            mainViewModel.tarefaSelecionda = null
            findNavController().navigate(R.id.action_listFragment_to_formFragment)

        }


        mainViewModel.myTarefaResponse.observe(viewLifecycleOwner){

            response ->

            if ( response != null ){

                adapter.setLista(response.body()!!)

            }

        }


        return binding.root



    }

    override fun onTaskClickListenter(tarefa: Tarefa) {
        mainViewModel.tarefaSelecionda = tarefa
        findNavController().navigate(R.id.action_listFragment_to_formFragment)
    }


}