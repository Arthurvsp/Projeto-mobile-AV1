package com.example.myprojectone.firstAplicattion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myprojectone.databinding.ActivityBuscaDadosBinding
import com.example.myprojectone.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbRef = FirebaseDatabase.getInstance().getReference()
        var edNome = binding.editNome
        var edIdade = binding.editIdade
        var edProfissao = binding.editProfissao
        var salva = binding.buttonCadastrar
        var ver = binding.buttonConsultar

        binding.buttonCadastrar!!.setOnClickListener { cadastra ->
            val empName = edNome.text.toString()
            val empIdade = edIdade.text.toString()
            val empProfissao = edProfissao!!.text.toString()

            if (empName.isEmpty()){
                edNome.error = "Insira um nome!"
        }
            if (empIdade.isEmpty()){
                edIdade.error = "Insira sua idade!"
            }
            if (empProfissao.isEmpty()){
                edProfissao.error = "Insira sua profissão!"
            }

            val empId = dbRef.push().key!!

            val funcionario = FuncionarioModelo(empId, empName, empIdade, empProfissao)

            dbRef.child(empId).setValue(funcionario)
                .addOnCompleteListener{
                    Toast.makeText(this, "Sucesso ao cadastrar", Toast.LENGTH_SHORT).show()
                    edNome.text.clear()
                    edIdade.text.clear()
                    edProfissao.text.clear()
                }.addOnFailureListener{err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
                }

        }

        binding.buttonConsultar.setOnClickListener {
            val i = Intent( this, BuscaDados::class.java)
            startActivity(i)
        }
    }
}