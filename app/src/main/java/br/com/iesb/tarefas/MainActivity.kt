package br.com.iesb.tarefas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)

        recyclerView.adapter = TarefaAdapter(TarefaService.consultarTarefas(), object : TarefaAdapter.TarefaListener {
            override fun onClickTarefa(view: View?, position: Int) {
                val tarefa = TarefaService.consultarTarefas()[position]

                Toast.makeText(this@MainActivity, "Minha Tarefa: ${tarefa.descricao}", Toast.LENGTH_LONG).show()
            }
        })

        addButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {

                if (tarefaTextView.text.isEmpty()) {
                    Toast.makeText(this@MainActivity, "Digite a descrição da tarefa", Toast.LENGTH_LONG).show()
                    return
                }

                val descricaoUsuario = tarefaTextView.text.toString()
                val tarefa = Tarefa(descricaoUsuario, Date())
                TarefaService.cadastrarTarefa(tarefa)

                recyclerView.adapter.notifyItemInserted(TarefaService.consultarTarefas().count() - 1)

                tarefaTextView.text.clear()
            }
        })
    }
}
