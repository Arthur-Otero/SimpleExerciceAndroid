package com.example.projetoaula

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlunosAdapter(private val alunosList: MutableList<Alunos>, val OnAlunoSelected: (Alunos, Int) -> Unit) : RecyclerView.Adapter<AlunosAdapter.AlunoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolder {
        return AlunoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.aluno_item, parent, false))
    }

    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
        holder.nome.text = alunosList[position].nome
        holder.matricula.text = alunosList[position].matricula

        holder.itemView.setOnClickListener {
            OnAlunoSelected(alunosList[position], position)
        }
    }

    fun alunosAdd(){
        alunosList.add(Alunos("Aluno ${alunosList.size}", "Matricula ${alunosList.size}"))
        notifyDataSetChanged()
    }

    fun infos() : Alunos{
        return Alunos(alunosList[alunosList.size-1].nome,alunosList[alunosList.size-1].matricula)
    }


    override fun getItemCount() = alunosList.size

    inner class AlunoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nome by lazy { view.findViewById<TextView>(R.id.tv_name) }
        val matricula by lazy { view.findViewById<TextView>(R.id.tv_matricula) }
    }
}