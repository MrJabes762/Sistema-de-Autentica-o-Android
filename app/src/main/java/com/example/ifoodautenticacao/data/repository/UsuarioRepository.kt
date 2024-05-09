package com.example.ifoodautenticacao.data.repository

import com.example.ifoodautenticacao.data.model.Usuario
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class UsuarioRepository {
    private val autenticacao by lazy {
        FirebaseAuth.getInstance()
    }
    suspend fun cadastrar(usuario: Usuario) : Boolean{
        return autenticacao.createUserWithEmailAndPassword(
            usuario.email,usuario.senha
        ).await() != null
    }
    suspend fun logar (usuario: Usuario) : Boolean{
        return autenticacao.signInWithEmailAndPassword(
            usuario.email,usuario.senha
        ).await() != null
    }
    fun listar () : List<String> {
        return listOf("Jabes","Ana","Marcos")
    }
    fun verificarUsuarioLogado () : Boolean{
        return true
    }

}