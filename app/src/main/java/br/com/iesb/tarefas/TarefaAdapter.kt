package br.com.iesb.tarefas

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.tarefa_cell.view.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by matheus.psousa on 05/04/2018.
 */
class TarefaAdapter(var listaTarefas : MutableList<Tarefa>, val tarefaListener: TarefaListener) : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {


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

        view?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {

                tarefaListener.onClickTarefa(view, position)

//                val tarefa = Tarefa(view?.tarefaTextView.text.toString(), Date())
//                TarefaService.cadastrarTarefa(tarefa)
//                Toast.makeText(this@MainActivity, teste[2].descricao, Toast.LENGTH_LONG).show()
            }
        })
    }

    class TarefaViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        /**
         * No Padrão antigo, Java, tinhamos que usar o findViewByID e setar em um atributo, mas o Kotlin encapsula essa complexidade
         */
    }

    interface TarefaListener {
        fun onClickTarefa(view : View?, position: Int)
    }

}