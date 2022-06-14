package com.example.projetotodoandroid

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.projetotodoandroid.databinding.FragmentFormBinding
import com.example.projetotodoandroid.fragment.DatePickerFragment
import com.example.projetotodoandroid.fragment.TimePickerListener
import com.example.projetotodoandroid.model.Categoria
import java.time.LocalDate


class FormFragment : Fragment(), TimePickerListener {

    private lateinit var binding : FragmentFormBinding
    private  val mainViewModel : MainViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      binding = FragmentFormBinding.inflate(layoutInflater, container, false)

        binding.editData.setOnClickListener {

            DatePickerFragment(this).show(parentFragmentManager, "DatePicker")

        }

        mainViewModel.listCategoria()

        mainViewModel.dataSelecionada.value = LocalDate.now()

        mainViewModel._myCategoriaResponse.observe(viewLifecycleOwner){ response ->

            Log.d("Requisição", response.body().toString())
            spinnerCategoria(response.body())

        }

        mainViewModel.dataSelecionada.observe(viewLifecycleOwner){

            selectdate -> binding.editData.setText(selectdate.toString())

        }


        binding.buttonSalvar.setOnClickListener {

            findNavController().navigate(R.id.action_formFragment_to_listFragment)

        }

        return binding.root
    }


    fun spinnerCategoria(listCategoria : List<Categoria>?){

        if ( listCategoria!= null ){

            binding.spinnerCategoria.adapter = ArrayAdapter(requireContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            , listCategoria)
        }


        }


    override fun onDateSelectd(date: LocalDate) {
        mainViewModel.dataSelecionada.value = date

    }
}
