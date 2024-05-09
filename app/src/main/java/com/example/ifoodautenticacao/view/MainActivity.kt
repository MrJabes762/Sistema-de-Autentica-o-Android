package com.example.ifoodautenticacao.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ifoodautenticacao.data.model.Usuario
import com.example.ifoodautenticacao.data.repository.UsuarioRepository
import com.example.ifoodautenticacao.databinding.ActivityMainBinding
import com.example.ifoodautenticacao.viewmodel.UsuarioViewModel

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var usuarioViewModel: UsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        usuarioViewModel = UsuarioViewModel(
            UsuarioRepository()
        )

        inicializarBotoes ()
        inicializarObservaveis()
    }

    private fun inicializarObservaveis() {
        usuarioViewModel.sucessoCadastro.observe(this){
            sucesso ->
                if (sucesso){
                    Toast.makeText(this, "Sucesso ao Cadastrar", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Falha ao Cadastrar", Toast.LENGTH_SHORT).show()
                }
        }
        usuarioViewModel.sucessoLogin.observe(this){
                sucesso ->
                if (sucesso){
                    Toast.makeText(this, "Sucesso ao Logar", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Falha ao Logar", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun inicializarBotoes() {
        binding.btnCadastrar.setOnClickListener{
            val email = binding.editemail.text.toString()
            val senha = binding.editsenha.text.toString()
                val usuario = Usuario (email,senha)

            usuarioViewModel.cadastrar(usuario)
        }
        binding.btnLogar.setOnClickListener{
            val email = binding.editemail.text.toString()
            val senha = binding.editsenha.text.toString()
                val usuario = Usuario (email, senha)
            usuarioViewModel.logar(usuario)
        }
    }
}