package com.example.comunicacaofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(),ActivityContract {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun finalizar(nome: String, numero: Int) {
        val fragmentProfile = supportFragmentManager.findFragmentById(R.id.fragment_form) as FragmentForm
        fragmentProfile.exibir(nome,numero)
    }

}