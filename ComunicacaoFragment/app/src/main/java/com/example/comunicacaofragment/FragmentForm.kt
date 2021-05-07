package com.example.comunicacaofragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentForm: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_form , container,false)
    }

    fun exibir(nome:String,num:Int){
        view?.let {
            it.findViewById<TextView>(R.id.exibir_nome).text = nome
            it.findViewById<TextView>(R.id.exibir_numero).text = num.toString()
        }
    }
}