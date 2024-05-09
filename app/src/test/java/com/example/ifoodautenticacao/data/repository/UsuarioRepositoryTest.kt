package com.example.ifoodautenticacao.data.repository

import org.junit.Assert.*

import org.junit.Test

class UsuarioRepositoryTest {

    @Test
    fun listar() {
        val usuarioRepository = UsuarioRepository ()
        val lista = usuarioRepository.listar()
        val retorno = lista.isNotEmpty()
        assert(retorno)
    }

    @Test
    fun verificarUsuarioLogado() {
        val usuarioRepository = UsuarioRepository ()
        val retorno = usuarioRepository.verificarUsuarioLogado()
        assert(retorno)
    }
}