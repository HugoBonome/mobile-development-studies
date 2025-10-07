package com.example.facesofopensource

import androidx.lifecycle.ViewModel
import com.example.facesofopensource.data.DataSource
import com.example.facesofopensource.data.Person
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow



class FacesViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(Person())
    val uiState = _uiState.asStateFlow()
    var pessoaAtual: Int = 0

    fun nomeAtual(): String{
        return DataSource.people[pessoaAtual].nome
    }
    fun descAtual(): String{
        return DataSource.people[pessoaAtual].desc
    }
    fun imagemAtual(): Int{
        return DataSource.people[pessoaAtual].imagem
    }

    fun anterior(){pessoaAtual = (pessoaAtual - 1).mod(DataSource.people.size)}

    fun proximo(){pessoaAtual = (pessoaAtual + 1).mod(DataSource.people.size) }

}