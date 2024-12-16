package com.example.practika2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.example.practika2.ui.theme.Practika2Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

open class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashscreen = installSplashScreen()
        var keepSplashScreen = true
        super.onCreate(savedInstanceState)
        splashscreen.setKeepOnScreenCondition { keepSplashScreen }
        lifecycleScope.launch {
            delay(5000)
            keepSplashScreen = false
        }
        enableEdgeToEdge()
        setContent {
            Practika2Theme {
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
    Column {
        Row(modifier = modifier.padding(10.dp)) {
            Text(
                text = "Пропустить",
                modifier = modifier.weight(1f),
                color = Color(0xFF57A9FF),
                textDecoration = TextDecoration.Underline
            )
            Image(
                painterResource(R.drawable.shape),
                contentDescription = "",
                modifier = Modifier.weight(1f)
                    .width(167.dp)
                    .height(163.dp)
            )
        }

        Row(modifier = modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = "Анализы",
                color = Color.Green
            )
            Text(
                text = "Экспресс сбор и получение проб",
                color = Color.Gray,
                modifier = Modifier.padding(start = 8.dp) // Добавляем немного отступа между текстами
            )
        }

        Image(
            painterResource(R.drawable.group1),
            contentDescription = "",
            modifier = Modifier.weight(1f).align(Alignment.CenterHorizontally).size(58.dp, 14.dp)
        )
        Image(
            painterResource(R.drawable.illustration),
            contentDescription = "",
            modifier = Modifier.weight(1f).align(Alignment.CenterHorizontally).size(200.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Practika2Theme {
        Greeting("Android")
    }
}