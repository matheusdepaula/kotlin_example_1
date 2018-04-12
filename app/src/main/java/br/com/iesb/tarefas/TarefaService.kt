package br.com.iesb.tarefas

import java.util.*

/**
 * Created by matheus.psousa on 05/04/2018.
 */
class TarefaService {

    companion object {

        var listaTarefa : MutableList<Tarefa> = mutableListOf()

        fun consultarTarefas() : MutableList<Tarefa> {
            return listaTarefa
        }

        fun cadastrarTarefa(tarefa: Tarefa) {
            listaTarefa.add(tarefa);
        }

        fun carregarTarefasFake() : MutableList<Tarefa> {

            var listaTemp = mutableListOf<Tarefa>()
            for (i in 1 .. 6) listaTemp.add(obterTarefaFake(i))

            return listaTemp
        }

        fun obterTarefaFake(numeroTarefa: Int) : Tarefa {
            return Tarefa("Tarefa $numeroTarefa", Date())
        }
    }
}