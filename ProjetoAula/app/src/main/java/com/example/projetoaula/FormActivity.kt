package com.example.projetoaula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FormActivity : AppCompatActivity() {
    val name by lazy { findViewById<TextView>(R.id.name_form) }
    val matricula by lazy { findViewById<TextView>(R.id.matricula_form) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form2)

        val extras = intent.extras

        name.text = extras?.getString("NAME")
        matricula.text = extras?.getString("MATRICULA")
    }
}