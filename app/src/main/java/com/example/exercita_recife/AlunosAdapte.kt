package com.example.exercita_recife

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlunosAdapte (private val alunoList: ArrayList<CadastroAluno>):
    RecyclerView.Adapter<AlunosAdapte.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunosAdapte.ViewHolder {
        val alunoView = LayoutInflater.from (parent.context).inflate(R.layout.card_aluno, parent, false)
        return ViewHolder(alunoView)
    }

    override fun onBindViewHolder(holder: AlunosAdapte.ViewHolder, position: Int) {
        val currentAluno = alunoList [position]
        holder.tvCardAluno.text = currentAluno.nomeAluno
    }

    override fun getItemCount(): Int {
        return alunoList.size
    }
    class ViewHolder(alunoView: View) : RecyclerView.ViewHolder(alunoView){
        val tvCardAluno: TextView = alunoView.findViewById(R.id.tvCardAluno)
    }
}