package com.example.myprojectone

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myprojectone.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val nome = i.extras?.getString("nome")
        val sobre = i.extras?.getString("sobrenome")

        binding.textNome.setText("$nome $sobre")

        binding.buttonNext2.setOnClickListener {
            val h = Intent(this, MainActivity3::class.java)

            startActivity(h)
        }



    }
}