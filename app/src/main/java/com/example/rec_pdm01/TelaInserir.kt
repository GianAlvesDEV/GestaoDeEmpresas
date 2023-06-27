package com.example.rec_pdm01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton


class TelaInserir : AppCompatActivity() {
    lateinit var bt_inserir: Button
    lateinit var bt_voltar: Button
    lateinit var et_cnpj: EditText
    lateinit var et_nome: EditText
    lateinit var et_caixa: EditText
    lateinit var rb_cinema: RadioButton
    lateinit var rb_acougue: RadioButton
    lateinit var rb_padaria: RadioButton
    lateinit var et_num_assentos: EditText
    lateinit var ed_peso_de_farinha: EditText
    lateinit var ed_peso_picanha: EditText
    lateinit var listaEmpresas: ArrayList<Empresa>
    lateinit var empresa: Empresa


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inserir)

        bt_inserir = findViewById(R.id.bt_inserir_empresa)
        et_cnpj = findViewById(R.id.et_cnpj_principal)
        et_caixa = findViewById(R.id.et_caixa_principal)
        et_nome = findViewById(R.id.et_nome_principal)
        rb_cinema = findViewById(R.id.rb_cinema)
        rb_padaria = findViewById(R.id.rb_padaria)
        rb_acougue = findViewById(R.id.rb_acougue)
        ed_peso_de_farinha = findViewById(R.id.ed_peso_de_farinha)
        et_num_assentos = findViewById(R.id.ed_num_assentos)
        ed_peso_picanha = findViewById(R.id.ed_peso_de_farinha)
        bt_voltar = findViewById(R.id.bt_voltar_inserir)
        listaEmpresas = ArrayList()


        bt_inserir.setOnClickListener{

            if(rb_cinema.isChecked){
                empresa = Cinema(et_num_assentos.text.toString().toInt(),et_cnpj.text.toString(),et_nome.text.toString(),et_caixa.text.toString().toFloat())
            }
            if(rb_acougue.isChecked){
                empresa = Acougue(ed_peso_picanha.text.toString().toFloat(),et_cnpj.text.toString(),et_nome.text.toString(),et_caixa.text.toString().toFloat())

            }
            if(rb_padaria.isChecked){
                empresa = Padaria(ed_peso_de_farinha.text.toString().toFloat(),et_cnpj.text.toString(),et_nome.text.toString(),et_caixa.text.toString().toFloat())
            }

            listaEmpresas.add(empresa)

        }

        bt_voltar.setOnClickListener{
            Intent().apply{
                putExtra("1",listaEmpresas)
                setResult(RESULT_OK,this)
            }
            finish()
        }
    }


}