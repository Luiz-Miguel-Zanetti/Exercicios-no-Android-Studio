package com.example.projetotodoandroid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.projetotodoandroid.databinding.FragmentFormBinding


class FormFragment : Fragment() {

    private lateinit var binding : FragmentFormBinding
    private  val mainViewModel : MainViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      binding = FragmentFormBinding.inflate(layoutInflater, container, false)

        mainViewModel._myCategoriaResponse.observe(viewLifecycleOwner){

            Log.d("Requisição", it.body().toString())

        }


        binding.buttonSalvar.setOnClickListener {

            findNavController().navigate(R.id.action_formFragment2_to_listFragment2)

        }

        return binding.root
    }




}