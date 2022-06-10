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
import com.example.projetotodoandroid.databinding.FragmentListBinding
import com.example.projetotodoandroid.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentListBinding.inflate(layoutInflater, container, false)



        binding.floatingAdd.setOnClickListener {

            findNavController().navigate(R.id.action_listFragment2_to_formFragment2)

            val adapter = NomeAdapter()

            binding.recyclerTarefa.adapter = adapter
            binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
            binding.recyclerTarefa.setHasFixedSize(true)

        }

        return binding.root
    }


}