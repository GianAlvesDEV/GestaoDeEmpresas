package com.example.rec_pdm01

class Padaria(pesoDafarinhaEstocada:Float,cnpj:String, nome:String, caixa: Float): Empresa(cnpj,nome,caixa),java.io.Serializable {
    val pesoDafarinhaEstocada: Float

    init {
        this.pesoDafarinhaEstocada = pesoDafarinhaEstocada
    }

    override fun toString(): String {
        return "Empresa(nome='$nome', CNPJ='$CNPJ', caixa=$caixa, light = '$pesoDafarinhaEstocada')"
    }
}