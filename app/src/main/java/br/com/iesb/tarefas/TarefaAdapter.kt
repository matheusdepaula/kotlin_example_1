package br.com.iesb.tarefas

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.tarefa_cell.view.*
import java.text.SimpleDateFormat

/**
 * Created by matheus.psousa on 05/04/2018.
 */
class TarefaAdapter(var listaTarefas : MutableList<Tarefa>) : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TarefaViewHolder {//Inflate a XML and Return

        val view = LayoutInflater.from(parent?.context).inflate(R.layout.tarefa_cell, parent, false)
        return TarefaViewHolder(view)
    }

    override fun getItemCount(): Int {//NumberOfRows
        return listaTarefas.size
    }

    override fun onBindViewHolder(holder: TarefaViewHolder?, position: Int) { //CellForRowAtIndex, next onCreateViewHolder

        val view = holder?.itemView

        val tarefa = listaTarefas[position]

        tarefa.descricao?.let {
            view?.tarefaTextView?.text = it
        }

        view?.dataTextView?.text = if(tarefa.data != null) SimpleDateFormat("dd/MM/yyyy").format(tarefa.data) else ""
    }

    class TarefaViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        /**
         * No Padrão antigo, Java, tinhamos que usar o findViewByID e setar em um atributo, mas o Kotlin encapsula essa complexidade
         */
    }

}