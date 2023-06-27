package com.example.rec_pdm01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class TelaCaixaTotal : AppCompatActivity() {
    private lateinit var bt_voltar_tela_caixa_total: Button
    private lateinit var lv_mostrar_caixa_total: ListView
    private lateinit var listaAuxiliar: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_caixa_total)

        bt_voltar_tela_caixa_total = findViewById(R.id.bt_voltar_tela_caixa_total)
        lv_mostrar_caixa_total = findViewById(R.id.lv_mostrar_caixa_total)

        listaAuxiliar = ArrayList()

        val bundle: Bundle? = intent.extras
        val aa_lista = ArrayAdapter(this,android.R.layout.simple_list_item_1,listaAuxiliar)

        bundle?.apply {
            val listaCursos: ArrayList<Empresa>? = getSerializable("3") as ArrayList<Empresa>?

            if (listaCursos != null) {
                if(listaCursos.size != 0 ){
                    listaAuxiliar.clear()
                    lv_mostrar_caixa_total.adapter = aa_lista
                    var total: Float = 0.0F
                    for(elemento in listaCursos){
                        total += elemento.caixa
                    }
                    listaAuxiliar.add("Total de dinhero no caixa: " + total.toString())
                    lv_mostrar_caixa_total.adapter = aa_lista
                }
                else{
                    listaAuxiliar.add("Nao há cursos cadastrados")
                    lv_mostrar_caixa_total.adapter = aa_lista
                }
            }
        }

        bt_voltar_tela_caixa_total.setOnClickListener{
            finish()
        }
    }
}