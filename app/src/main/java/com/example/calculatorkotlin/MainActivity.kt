package com.example.calculatorkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculatorkotlin.ui.theme.CalculatorKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorKotlinTheme {
                Calculator()
            }
        }
    }
}

@Composable
fun Calculator(modifier: Modifier = Modifier) {
    var ketQua by remember { mutableStateOf<String>("") }
    var so1 = remember { mutableStateOf("") }
    var so2 = remember { mutableStateOf("") }
    var loi by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            "Calculator",
            modifier = modifier.fillMaxWidth().background(color = Color.Blue),
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            textAlign = androidx.compose.ui.text.style.TextAlign.Start
        )

        TextField(
            value = so1.value,
            onValueChange = { so1.value = it },
            label = { Text("Số 1") },
            isError = loi.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = so2.value,
            onValueChange = { so2.value = it },
            label = { Text("Số 2") },
            isError = loi.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = {
                val num1 = so1.value.toIntOrNull()
                val num2 = so2.value.toIntOrNull()

                if (num1 == null || num2 == null) {
                    loi = "Vui lòng nhập số hợp lệ."
                } else {
                    ketQua = (num1 + num2).toString()
                    loi = ""
                }
            }) {
                Text(text = "+")
            }

            IconButton(onClick = {
                val num1 = so1.value.toIntOrNull()
                val num2 = so2.value.toIntOrNull()

                if (num1 == null || num2 == null) {
                    loi = "Vui lòng nhập số hợp lệ."
                } else {
                    ketQua = (num1 - num2).toString()
                    loi = ""
                }
            }) {
                Text(text = "-")
            }

            IconButton(onClick = {
                val num1 = so1.value.toIntOrNull()
                val num2 = so2.value.toIntOrNull()

                if (num1 == null || num2 == null) {
                    loi = "Vui lòng nhập số hợp lệ."
                } else {
                    ketQua = (num1 * num2).toString()
                    loi = ""
                }
            }) {
                Text(text = "×")
            }

            IconButton(onClick = {
                val num1 = so1.value.toIntOrNull()
                val num2 = so2.value.toIntOrNull()

                if (num1 == null || num2 == null) {
                    loi = "Vui lòng nhập số hợp lệ."
                } else if (num2 == 0) {
                    loi = "Không thể chia cho 0."
                } else {
                    ketQua = (num1 / num2).toString()
                    loi = ""
                }
            }) {
                Text(text = "/")
            }
        }

        if (loi.isNotEmpty()) {
            Text(text = loi, color = Color.Red, modifier = Modifier.align(Alignment.CenterHorizontally))
        } else if (ketQua.isNotEmpty()) {
            Text(text = "Kết quả: $ketQua", modifier = Modifier.align(Alignment.CenterHorizontally))
        } else {
            Text(text = "Kết quả:...", modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}


@Preview()
@Composable
fun CalculatorPreview() {
    CalculatorKotlinTheme {
        Calculator()
    }
}
