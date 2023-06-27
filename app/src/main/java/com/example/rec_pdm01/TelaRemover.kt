package com.example.rec_pdm01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class TelaRemover : AppCompatActivity() {
    private lateinit var bt_voltar: Button
    private lateinit var listaAux: ArrayList<String>
    private lateinit var lv_lista: ListView
    private lateinit var lista: ArrayList<Empresa>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_remover)

        listaAux = ArrayList()


        val aa_empresa = ArrayAdapter(this,android.R.layout.simple_list_item_1,listaAux)


        bt_voltar = findViewById(R.id.bt_voltar_remover)
        lv_lista = findViewById(R.id.lv_remover)

        lista = (intent.getSerializableExtra("4") as ArrayList<Empresa>?)!!

        if(lista!=null){
            if(lista.size!=0) {
                for (elemento in lista) {
                    listaAux.add(elemento.toString())
                }
                lv_lista.adapter = aa_empresa
            }
            else{
                listaAux.add("Nenhum curso cadastrado")
                lv_lista.adapter = aa_empresa
            }
        }

        lv_lista.onItemClickListener = AdapterView.OnItemClickListener{
                parant,view,position,id ->
            if(lista.size!=0){
                lista.removeAt(position)

                if(lista.size!=0) {
                    listaAux.clear()
                    lv_lista.adapter = aa_empresa

                    for (elemento in lista) {
                        listaAux.add(elemento.toString())
                    }

                    lv_lista.adapter = aa_empresa
                }
                else{
                    listaAux.clear()
                    lv_lista.adapter = aa_empresa
                    listaAux.add("Nao há cursos cadastrados")
                    lv_lista.adapter = aa_empresa
                }
            }

        }

        bt_voltar.setOnClickListener{
            Intent().apply{
                putExtra("222",lista)
                setResult(RESULT_OK,this)
            }
            finish()
        }
    }
}