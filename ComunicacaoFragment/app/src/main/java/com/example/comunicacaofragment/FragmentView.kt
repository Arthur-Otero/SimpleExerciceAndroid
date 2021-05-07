package com.example.comunicacaofragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText

class FragmentView : Fragment() {
    val botao by lazy { view?.findViewById<Button>(R.id.botao_confirmar) }
    val textoNome by lazy { view?.findViewById<TextInputEditText>(R.id.text_nome) }
    val textoTel by lazy { view?.findViewById<TextInputEditText>(R.id.text_telefone) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        botao?.setOnClickListener{
            finalizar()
        }
    }

    private fun finalizar() {
        val activityContract = requireActivity() as ActivityContract

        val nome=textoNome?.text.toString()
        val numero=textoTel?.text.toString()

        activityContract.finalizar(nome,numero.toInt())
    }
}