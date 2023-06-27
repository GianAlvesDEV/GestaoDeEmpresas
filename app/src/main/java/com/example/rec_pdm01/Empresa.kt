package com.example.rec_pdm01

import java.io.Serializable


open class Empresa(cnpj:String, nome:String, caixa: Float): Serializable{
    val nome:String
    val CNPJ:String
    val caixa: Float
    init {
        this.nome = nome
        this.CNPJ = cnpj
        this.caixa = caixa
    }

    override fun toString(): String {
        return "Empresa(nome='$nome', CNPJ='$CNPJ', caixa=$caixa)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Empresa

        if (nome != other.nome) return false
        if (CNPJ != other.CNPJ) return false
        if (caixa != other.caixa) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nome.hashCode()
        result = 31 * result + CNPJ.hashCode()
        result = 31 * result + caixa.hashCode()
        return result
    }

}