package br.com.iesb.tarefas

import java.util.*

/**
 * Created by matheus.psousa on 05/04/2018.
 */
class Tarefa {

    var descricao : String? = null
    var data : Date? = null

    constructor()

    constructor(descricao: String?, data: Date?) {
        this.descricao = descricao
        this.data = data
    }
}