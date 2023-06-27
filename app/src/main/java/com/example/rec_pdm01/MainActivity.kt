package com.example.rec_pdm01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity() {
    lateinit var bt_inserir: Button
    lateinit var bt_remover: Button
    lateinit var bt_alterar: Button
    lateinit var bt_mostrar: Button
    lateinit var bt_caixa_total: Button
    lateinit var lista_empresas: ArrayList<Empresa>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_inserir = findViewById(R.id.bt_inserir_empresa)
        bt_remover = findViewById(R.id.bt_remover)
        bt_alterar = findViewById(R.id.bt_alterar)
        bt_mostrar = findViewById(R.id.bt_mostrar)
        bt_caixa_total = findViewById(R.id.bt_mostrar_caixa_total)
        lista_empresas = ArrayList()



        bt_inserir.setOnClickListener{
            Intent(this,TelaInserir::class.java).let{
                register.launch(it)
            }
        }

        bt_mostrar.setOnClickListener{
            val intent = Intent(this,TelaMostrar::class.java).apply {
                putExtra("2",lista_empresas)
            }
            startActivity(intent)
        }

        bt_caixa_total.setOnClickListener{
            val intent = Intent(this,TelaCaixaTotal::class.java).apply {
                putExtra("3",lista_empresas)
            }
            startActivity(intent)
        }

        bt_remover.setOnClickListener{
            Intent(this,TelaRemover::class.java).let{
                it.putExtra("4",lista_empresas)
                register.launch(it)
            }
        }
    }


    private val register = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    )


    { result: androidx.activity.result.ActivityResult ->
        if(result.resultCode == RESULT_OK){
            result.data?.let {
                val listaRetornando = it.getSerializableExtra("1") as? ArrayList<*>

                if(listaRetornando!=null){
                    for (elemento in listaRetornando){
                        lista_empresas.add(elemento as Empresa)
                    }

                }


                if (it.hasExtra("222")){
                    val listaRetornando = it.getSerializableExtra("222") as? ArrayList<Empresa>

                    if(listaRetornando!=null){
                        lista_empresas = listaRetornando

                    }
                }
            }
        }
    }
}