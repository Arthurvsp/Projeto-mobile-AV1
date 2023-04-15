package com.example.myprojectone

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myprojectone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNext.setOnClickListener {
            val nome = binding.editName.text.toString()
            val sobre = binding.editSobrenome.text.toString()

            val i = Intent(this, MainActivity2::class.java)
            i.putExtra("nome", nome)
            i.putExtra("sobrenome", sobre)

            if (nome.equals("") || nome == null){
                Toast.makeText(applicationContext, "Nome não inserido", Toast.LENGTH_SHORT).show()
            }else {
                startActivity(i)
            }
        }
    }
}