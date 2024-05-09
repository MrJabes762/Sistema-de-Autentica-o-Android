package com.example.ifoodautenticacao.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ifoodautenticacao.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val autenticacao by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        inicializarBotoes ()
    }

    private fun inicializarBotoes() {
        binding.btnCadastrar.setOnClickListener{
            val email = binding.editemail.text.toString()
            val senha = binding.editsenha.text.toString()
            autenticacao.createUserWithEmailAndPassword(
                email, senha
            ).addOnSuccessListener{
                Toast.makeText(this, "Sucesso ao Cadastrar", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this, "Falha ao Cadastrar", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnLogar.setOnClickListener{
            val email = binding.editemail.text.toString()
            val senha = binding.editsenha.text.toString()
            autenticacao.signInWithEmailAndPassword(
                email, senha
            ).addOnSuccessListener{
                Toast.makeText(this, "Sucesso ao Logar", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this, "Falha ao Logar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}