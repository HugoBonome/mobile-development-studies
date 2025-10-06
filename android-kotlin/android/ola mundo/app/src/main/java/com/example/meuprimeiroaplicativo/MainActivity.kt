package com.example.meuprimeiroaplicativo

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meuprimeiroaplicativo.ui.theme.MeuPrimeiroAplicativoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeuPrimeiroAplicativoTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Surface (
//        color = MaterialTheme.colorScheme.primaryContainer,
//        modifier = modifier
//            .fillMaxWidth()
//            .windowInsetsPadding(WindowInsets.statusBars)
//    ){
//        Column {
//            Text(
//                text = "Hello $name!",
//                fontSize = 36.sp,
//                fontStyle = FontStyle.Italic,
//                fontWeight = FontWeight.Bold,
//                textAlign = TextAlign.Center,
//                modifier = modifier.padding(24.dp)
//            )
//            Text(
//                text = "PALMEIRAS",
//                fontSize = 36.sp,
//                fontStyle = FontStyle.Italic,
//                fontWeight = FontWeight.Bold,
//                textAlign = TextAlign.Center,
//                modifier = modifier.padding(24.dp)
//            )
//        }
//    }
//}

@Composable
fun Saudacao(nome: String, modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
//                verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Olá")
            Text(text = nome)
        }
    }
}

@Composable
fun DuplicaSaudacao(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
    ){
        Column(
            modifier = Modifier, verticalArrangement = Arrangement.Center
        ) {
            Saudacao("Cas", Modifier.weight(4f))
            Saudacao("Hugoooo", Modifier.weight(10f))
        }


    }
}

@Composable
fun ImagemDeFundo(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .windowInsetsPadding(WindowInsets.statusBars)
            .fillMaxSize()
    ){
        Box(
            modifier = Modifier
        ) {
            Image(
                painter = painterResource(R.drawable.fundo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = 0.2f
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
            Text(
                text = "Bom dia",
                fontSize = 120.sp,
                lineHeight = 116.sp,
                textAlign = TextAlign.Center,
            )
                Text(
                    text = "ADS",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.End)
                )
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ImagemPreview() {
    ImagemDeFundo()
}
@Preview(showBackground = true, showSystemUi = true)
@Composable()
private fun SaudacaoPreview() {
    DuplicaSaudacao()
}

@Composable
fun PingPong(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .windowInsetsPadding(WindowInsets.statusBars)
    ){
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(R.drawable.luthfi_alfarizi_unsplash),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
            )
            Text(
                text = "Tênis de mesa",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "O tênis de mesa surgiu na Inglaterra no século XIX imitando o jogo de tênis em um ambiente fechado.",
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp),
                fontSize = 20.sp
            )
            Text(
                text = "Uma partida de tênis de mesa é disputada em melhor de qualquer número de sets ímpares. Usualmente, torneios nacionais são disputados em melhor de 5 sets e torneios internacionais em melhor de 7 sets, o que significa que o jogador ou dupla que vencer, respectivamente, 3 ou 4 sets vence a partida. Para vencer um set, o jogador ou a dupla precisa conseguir 11 pontos, ou em caso de empate em 10 pontos, somar dois pontos de vantagem em relação ao seu adversário. ",
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp),
                fontSize = 20.sp
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PingPongPreview() {
    PingPong()
}
