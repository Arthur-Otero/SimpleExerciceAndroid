package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private val btnCalcular by lazy { findViewById<Button>(R.id.btnCalcular) }
    private val textoSoma by lazy { findViewById<TextView>(R.id.textosoma) }
    private val primeiroValor by lazy { findViewById<TextInputEditText>(R.id.primeiroValor) }
    private val segundoValor by lazy { findViewById<TextInputEditText>(R.id.segundoValor) }
    private val layout1 by lazy { findViewById<TextInputLayout>(R.id.layout1) }
    private val layout2 by lazy { findViewById<TextInputLayout>(R.id.layout2) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener{
            val valor1 = primeiroValor?.text.toString()
            val valor2 = segundoValor?.text.toString()
            hideKeyboard()
            dectarErro()
        }
    }

    private fun soma(valor1: Int, valor2: Int): String {
        val soma = valor1+valor2
        return soma.toString()
    }

    private fun dectarErro(){
        val valor1 = primeiroValor?.text.toString()
        val valor2 = segundoValor?.text.toString()

        when{
            valor1.isBlank() && valor2.isBlank()-> {
                layout1?.error = "Número invalido"
                layout2?.error = "Número invalido"
            }
            valor2.isBlank()->{
                layout1?.error = null
                layout2?.error = "Número invalido"
            }
            valor1.isBlank()->{
                layout1?.error = "Número invalido"
                layout2?.error = null
            }
            else -> textoSoma.text = soma(valor1.toInt(),valor2.toInt())
        }
    }

    private fun hideKeyboard() {
        val inputService = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputService.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}