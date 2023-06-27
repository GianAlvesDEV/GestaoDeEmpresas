package com.example.rec_pdm01

class Acougue(pesoDaPicanhaEstocado:Float,cnpj:String, nome:String, caixa: Float):Empresa(cnpj,nome,caixa),java.io.Serializable {
    val pesoDaPicanhaEstocado:Float
    init {
        this.pesoDaPicanhaEstocado = pesoDaPicanhaEstocado
    }
    override fun toString(): String {
        return "Empresa(nome='$nome', CNPJ='$CNPJ', caixa=$caixa, capacidade do tanque = '$pesoDaPicanhaEstocado')"
    }
}