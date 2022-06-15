package com.example.projetotodoandroid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.projetotodoandroid.databinding.FragmentFormBinding
import com.example.projetotodoandroid.fragment.DatePickerFragment
import com.example.projetotodoandroid.fragment.TimePickerListener
import com.example.projetotodoandroid.model.Categoria
import com.example.projetotodoandroid.model.Tarefa
import java.time.LocalDate
import java.util.logging.Level


class FormFragment : Fragment(), TimePickerListener {

    private lateinit var binding : FragmentFormBinding
    private  val mainViewModel : MainViewModel by activityViewModels()
    private  var categoriaSelecionada = 0L



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

        mainViewModel.myCategoriaResponse.observe(viewLifecycleOwner){ response ->

            Log.d("Requisição", response.body().toString())
            spinnerCategoria(response.body())

        }

        mainViewModel.dataSelecionada.observe(viewLifecycleOwner){

            selectdate -> binding.editData.setText(selectdate.toString())

        }


        binding.buttonSalvar.setOnClickListener {

            inserirNoBanco()

        }

        return binding.root
    }


  private  fun spinnerCategoria(listCategoria : List<Categoria>?){

        if ( listCategoria!= null ){

            binding.spinnerCategoria.adapter = ArrayAdapter(requireContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            , listCategoria)
        }

        binding.spinnerCategoria.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener{

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    val selected = binding.spinnerCategoria.selectedItem as Categoria

                    categoriaSelecionada = selected.id

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }


        }

    private fun validarCampos(nomeTarefa: String, descriçãoTarefa: String, responsavel:String) : Boolean{

        return !(nomeTarefa == "" || nomeTarefa.length < 3 || nomeTarefa.length> 20)||
                (descriçãoTarefa == ""|| descriçãoTarefa.length <5 || descriçãoTarefa.length > 200)||
                (responsavel == ""|| responsavel.length <5 || responsavel.length > 20)
    }

    private fun inserirNoBanco(){

        val nome = binding.editNome.text.toString()
        val descriçãoTarefa = binding.editDescricao.text.toString()
        val responsavel = binding.editResponsavel.text.toString()
        val data = binding.editData.text.toString()
        val status = binding.switchAtivoCard.isChecked
        val categoria = Categoria(categoriaSelecionada, null, null)

        if (validarCampos(nome, descriçãoTarefa, responsavel)){

            val tarefa = Tarefa(0,nome, descriçãoTarefa, responsavel, data, status, categoria)
            mainViewModel.addTarefa(tarefa)
            Toast.makeText(context, "Tarefa cadastrada com sucesso", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_formFragment_to_listFragment)




        }else{

            Toast.makeText(context, "Preencha os campos corretamente", Toast.LENGTH_LONG).show()

        }

    }





    override fun onDateSelectd(date: LocalDate) {
        mainViewModel.dataSelecionada.value = date

    }
}
