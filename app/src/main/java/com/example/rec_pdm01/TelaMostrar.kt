package com.example.rec_pdm01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class TelaMostrar : AppCompatActivity() {
    private lateinit var bt_voltar: Button
    private lateinit var lv_lista: ListView
    private lateinit var listaAux: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_mostrar)
        bt_voltar = findViewById(R.id.bt_voltar_mostrar)
        lv_lista = findViewById(R.id.lv_lista)
        listaAux = ArrayList()

        val bundle: Bundle? = intent.extras
        val aa_empresa = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaAux)

        bundle?.apply {
            val listaEmpresa: ArrayList<Empresa>? = getSerializable("2") as ArrayList<Empresa>

            if (listaEmpresa != null) {
                if (listaEmpresa.size != 0) {
                    listaAux.clear()
                    lv_lista.adapter = aa_empresa

                    for (elemento in listaEmpresa) {
                        listaAux.add(elemento.toString())
                    }
                    lv_lista.adapter = aa_empresa
                } else {
                    listaAux.add("Nenhum curso cadastrado")
                    lv_lista.adapter = aa_empresa
                }
            }
        }

        bt_voltar.setOnClickListener {
            finish()
        }
    }
}