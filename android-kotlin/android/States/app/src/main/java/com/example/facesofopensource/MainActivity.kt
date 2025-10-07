package com.example.facesofopensource

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.facesofopensource.data.DataSource
import com.example.facesofopensource.ui.theme.FacesOfOpenSourceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FacesOfOpenSourceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Faces(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    @Composable
    fun Faces(modifier: Modifier = Modifier, viewModel: FacesViewModel = viewModel()) {

        Surface(
            modifier = Modifier
                .fillMaxSize(),
            // border = BorderStroke(1.dp, Color.Black),
            shadowElevation = 10.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(32.dp)
                    .windowInsetsPadding(WindowInsets.statusBars),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(viewModel.imagemAtual()),
                    modifier = Modifier.padding(10.dp).shadow(elevation = 8.dp).weight(4f),
                    contentDescription = null,
                    contentScale = ContentScale.Crop

                )
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .weight(6f)
                        .padding(top = 16.dp)
                        .background(Color.LightGray),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = viewModel.nomeAtual(),
                        fontSize = (36.sp),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                    )
                    Text(
                        text = viewModel.descAtual(),
                        fontSize = (16.sp),
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                    )

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth().weight(1f),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Bottom
                ){
                    Button(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        onClick = {viewModel.anterior()}) {
                        Text("Anterior")
                    }
                    Button(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        onClick = {viewModel.proximo()}) {
                        Text("Próximo")
                    }
                }
            }
        }
    }

    @Preview(showBackground = false, showSystemUi = true)
    @Composable
    private fun FacesPreview() {
        Faces()
    }
}
