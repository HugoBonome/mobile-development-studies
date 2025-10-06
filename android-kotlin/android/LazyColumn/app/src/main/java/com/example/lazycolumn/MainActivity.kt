package com.example.lazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazycolumn.ui.theme.LazyColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyColumnTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

data class Disciplina(
    val sigla: String, val nome:
    String, val cargaHoraria: Int, val ementa: String
)

object DataSource {
    val disciplinas = listOf(
        Disciplina("ALC", "Algoritmos e Complexidade", 80, "Estudo de algoritmos avançados, técnicas de projeto (divisão e conquista, programação dinâmica, algoritmos gulosos) e análise de complexidade de tempo e espaço."),
        Disciplina("ESW", "Engenharia de Software", 80, "Introdução aos processos de desenvolvimento de software, metodologias ágeis (Scrum, Kanban), levantamento de requisitos, modelagem UML e ciclo de vida de software."),
        Disciplina("TQS", "Teste e Qualidade de Software", 60, "Introdução aos conceitos de verificação e validação, tipos de testes (unitário, integração, sistema), automação de testes e métricas de qualidade de software."),
        Disciplina("AQS", "Arquitetura de Software", 80, "Estudo de padrões arquiteturais (MVC, Microserviços, Monolítico), atributos de qualidade (desempenho, segurança, escalabilidade) e documentação de arquitetura."),
        Disciplina("PDP", "Padrões de Projeto", 60, "Aplicação dos padrões de projeto do GoF (Gang of Four), divididos em criacionais, estruturais e comportamentais para resolver problemas comuns de design de software."),
        Disciplina("SOP", "Sistemas Operacionais", 80, "Fundamentos sobre gerenciamento de processos, memória, sistemas de arquivos, concorrência (threads, semáforos) e escalonamento de CPU."),
        Disciplina("RDC", "Redes de Computadores", 80, "Análise do modelo OSI e da arquitetura TCP/IP, protocolos de rede, endereçamento IP, roteamento e serviços de transporte de dados."),
        Disciplina("SDI", "Sistemas Distribuídos", 80, "Conceitos de sistemas distribuídos, comunicação entre processos, concorrência, consistência de dados, tolerância a falhas e algoritmos de coordenação."),
        Disciplina("NUV", "Computação em Nuvem", 60, "Fundamentos de Cloud Computing, modelos de serviço (IaaS, PaaS, SaaS), virtualização, contêineres (Docker, Kubernetes) e arquiteturas serverless."),
        Disciplina("DVO", "DevOps e Automação", 60, "Princípios da cultura DevOps, integração contínua (CI), entrega contínua (CD), automação de infraestrutura como código (IaC) e monitoramento de aplicações."),
        Disciplina("BDD", "Banco de Dados", 80, "Modelagem de dados relacional e não relacional (NoSQL), linguagem SQL, normalização, transações e gerenciamento de bancos de dados."),
        Disciplina("MDT", "Mineração de Dados", 80, "Técnicas para extração de conhecimento de grandes volumes de dados, incluindo pré-processamento, regras de associação, classificação e clusterização."),
        Disciplina("AML", "Aprendizado de Máquina", 80, "Estudo de algoritmos de aprendizado supervisionado (regressão, classificação), não supervisionado (clusterização) e introdução a redes neurais."),
        Disciplina("PLN", "Processamento de Linguagem Natural", 60, "Técnicas para análise e processamento de texto, incluindo tokenização, stemming, análise sintática, modelos de tópicos e análise de sentimentos."),
        Disciplina("BGD", "Big Data", 60, "Conceitos do ecossistema de Big Data, incluindo os 5 Vs (Volume, Velocidade, Variedade, Veracidade, Valor), ferramentas como Hadoop e Spark, e processamento de dados em larga escala."),
        Disciplina("LFA", "Linguagens Formais e Autômatos", 80, "Estudo de gramáticas formais, autômatos finitos, autômatos de pilha, máquinas de Turing e a hierarquia de Chomsky como base da computação."),
        Disciplina("CGR", "Computação Gráfica", 80, "Fundamentos da geração de imagens por computador, transformações geométricas 2D e 3D, algoritmos de renderização, modelagem e texturização."),
        Disciplina("CSD", "Criptografia e Segurança de Dados", 60, "Estudo de algoritmos criptográficos simétricos e assimétricos, funções de hash, assinaturas digitais e protocolos de segurança para proteção de dados."),
        Disciplina("UXD", "Experiência do Usuário (UX/UI)", 60, "Princípios de design centrado no usuário, pesquisa com usuários, prototipação, testes de usabilidade e criação de interfaces intuitivas e eficazes."),
        Disciplina("GTI", "Governança de TI e Ética", 60, "Estudo de frameworks de governança (COBIT, ITIL), gestão de riscos, conformidade, segurança da informação e as implicações éticas e legais na tecnologia.")
    )
}

@Composable
fun CartaoDisciplina(disciplina: Disciplina, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier.animateContentSize().padding(8.dp),
        elevation = cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            var isExpanded by rememberSaveable { mutableStateOf(false) }
            Text(
                text = disciplina.sigla,
            )
            Column(
                modifier = Modifier.clickable { isExpanded = !isExpanded }
            ) {
                Text(
                    text =  disciplina.nome,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Carga horária: ${disciplina.cargaHoraria} horas"
                )
                Text(
                    text = "Ementa: ${disciplina.ementa}",
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}


@Composable
fun ListaDisciplinas(disciplinas: List<Disciplina>) {
    LazyColumn {
        items(disciplinas) { disciplina ->
            CartaoDisciplina(
                disciplina = disciplina
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ListaDisciplinasPreview() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        ListaDisciplinas(DataSource.disciplinas)
    }
}