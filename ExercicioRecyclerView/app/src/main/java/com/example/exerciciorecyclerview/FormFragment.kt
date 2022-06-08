package com.example.exerciciorecyclerview

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.exerciciorecyclerview.R
import com.example.exerciciorecyclerview.databinding.FragmentFormBinding

class FormFragment : Fragment() {

    private lateinit var binding: FragmentFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFormBinding.inflate(layoutInflater, container, false)

        binding.buttonSalvar.setOnClickListener {

            findNavController().navigate(R.id.action_formFragment2_to_listFragment3)

        }

        return binding.root
    }

}
