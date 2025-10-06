package com.example.jogodedados

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

enum class situacaoJogo {
    INICIO, PONTO, VENCEU, PERDEU
}

data class DadosUiState(
    val dado1: Int = 6,
    val dado2: Int = 6,
    val situacaoJogo: situacaoJogo = com.example.jogodedados.situacaoJogo.INICIO,
    val pontoASerBuscado: Int = 0

)

class DadosViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DadosUiState())
    val uiState = _uiState.asStateFlow()

    fun jogarDados(){
        val d1 = (1..6).random()
        val d2 = (1..6).random()
        val soma = d1 + d2

        _uiState.update {
            estadoAtual -> estadoAtual.copy(dado1 = d1, dado2 = d2)
        }

        // Lógica do jogo
        val novoEstado = when (uiState.value.situacaoJogo) {
            situacaoJogo.INICIO -> {
                when (soma) {
                    7, 11 -> DadosUiState(dado1 = d1, dado2 = d2, situacaoJogo = situacaoJogo.VENCEU)
                    2, 3, 12 -> DadosUiState(dado1 = d1, dado2 = d2, situacaoJogo = situacaoJogo.PERDEU)
                    else -> DadosUiState(
                        dado1 = d1,
                        dado2 = d2,
                        situacaoJogo = situacaoJogo.PONTO,
                        pontoASerBuscado = soma
                    )
                }
            }

            situacaoJogo.PONTO -> {
                when (soma) {
                    _uiState.value.pontoASerBuscado -> DadosUiState(dado1 = d1, dado2 = d2, situacaoJogo = situacaoJogo.VENCEU)
                    7 -> DadosUiState(dado1 = d1, dado2 = d2, situacaoJogo = situacaoJogo.VENCEU)
                    else -> DadosUiState(
                        dado1 = d1,
                        dado2 = d2,
                        situacaoJogo = situacaoJogo.PONTO,
                        pontoASerBuscado = _uiState.value.pontoASerBuscado
                    )
                }
            }

            else -> DadosUiState(
                dado1 = 6,
                dado2 = 6,
                situacaoJogo = situacaoJogo.INICIO,
                pontoASerBuscado = 0
            )

        }


    }

    fun getMensagem(): String{
        return when (_uiState.value.situacaoJogo) {
            situacaoJogo.INICIO -> "Clique em jogar dados"
            situacaoJogo.PONTO -> "Ponto a ser buscado: ${_uiState.value.pontoASerBuscado}"
            situacaoJogo.VENCEU -> "Você venceu"
            situacaoJogo.PERDEU -> "Você perdeu"
        }
    }

    fun getTextoBotao(): String {
        return when (_uiState.value.situacaoJogo) {
            situacaoJogo.INICIO, situacaoJogo.PONTO -> "Jogar dados"
            else -> "Reiniciar jogo"
        }
    }

}