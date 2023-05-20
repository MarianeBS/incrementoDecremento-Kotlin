package com.example.teste

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.teste.ui.theme.TesteTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get


class MainActivity : ComponentActivity()
{
    private lateinit var minhaViewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        minhaViewModel = ViewModelProvider(this).get(ViewModel::class.java)

        setContent {
            MainScreen(minhaViewModel)
        }
    }
}

@Composable
fun MainScreen(umaViewModel: ViewModel){
    var contadorNaView by remember {
        mutableStateOf(0)
    }

    val contadorDaModelView by umaViewModel.contadorDaViewPublico.collectAsState()
    Column() {
        Button(onClick = {
            contadorNaView = contadorNaView + 1
            umaViewModel.incrementaContador()
        }) {
            Text(text = "Incrementar contador")
        }

        Button(onClick = {
            contadorNaView = contadorNaView - 1
            umaViewModel.deincrementaContador()
        }) {
            Text(text = "Derementar contador")
        }

        Text(text = "Valor do contador = $contadorNaView")
        Text(text = "Valor do contador controlado na Model View = $contadorDaModelView")
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    //MainScreen()
}