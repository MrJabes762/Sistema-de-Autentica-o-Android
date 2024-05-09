package com.example.ifoodautenticacao.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.ifoodautenticacao.data.model.Usuario
import com.example.ifoodautenticacao.data.repository.UsuarioRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class UsuarioViewModel (
    private val usuarioRepository : UsuarioRepository
){
    val sucessoCadastro  = MutableLiveData<Boolean>()
    val sucessoLogin = MutableLiveData<Boolean>()
    fun cadastrar(usuario: Usuario) {
        CoroutineScope( Dispatchers.IO).launch {
            val resposta = usuarioRepository.cadastrar(usuario)
            sucessoCadastro.postValue(resposta)
        }
    }
    fun logar(usuario: Usuario){
        CoroutineScope (Dispatchers.IO).launch{
            val resposta = usuarioRepository.logar(usuario)
            sucessoLogin.postValue(resposta)
        }
    }
}