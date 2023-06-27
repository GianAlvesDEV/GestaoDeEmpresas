package com.example.rec_pdm01

import java.io.Serializable

class Cinema(numeroDeAssentos: Int,cnpj:String,nome:String,caixa:Float): Empresa(cnpj , nome , caixa ),Serializable{

    val numeroDeAssentos: Int
    init {
        this.numeroDeAssentos = numeroDeAssentos
    }

    override fun toString(): String {
        return "Empresa(nome='$nome', CNPJ='$CNPJ', caixa=$caixa, numero de assentos = '$numeroDeAssentos')"
    }

}