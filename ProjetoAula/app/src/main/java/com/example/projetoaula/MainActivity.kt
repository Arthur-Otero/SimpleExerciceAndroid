package com.example.projetoaula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    val recycler by lazy { findViewById<RecyclerView>(R.id.recycler_view) }
    val button by lazy { findViewById<Button>(R.id.button) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alunos = getAlunos()

        recycler.layoutManager = LinearLayoutManager(this)

        val adapter = AlunosAdapter(alunos) { aluno, pos ->
            makeText(this, "$aluno , posição : $pos", Toast.LENGTH_LONG).show()
        }

        button.setOnClickListener {
            adapter.alunosAdd()

            val intent = Intent(this, FormActivity::class.java)

            val nome = adapter.infos()

            intent.putExtra("NAME", nome.nome)
            intent.putExtra("MATRICULA", nome.matricula)

            startActivity(intent)
        }

        recycler.adapter = adapter
    }

    private fun getAlunos(): MutableList<Alunos> {
        val alunosList = mutableListOf<Alunos>()

        for (index in 0..30) {
            val aluno = Alunos("Aluno $index", "Matricula $index")
            alunosList.add(aluno)
        }

        return alunosList
    }
}