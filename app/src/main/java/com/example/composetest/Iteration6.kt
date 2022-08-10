package com.example.composetest

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
@Composable
fun Iteration6() {
    Box(modifier = Modifier.fillMaxSize()) {
        var Iteration6_Data by remember {
            mutableStateOf(Iteration6_Data())
        }

        var time by remember {
            mutableStateOf("")
        }

        LaunchedEffect(true) {
            while (true) {
                delay(1000)
                val pattern = "HH:mm:ss"
                val simpleDateFormat = SimpleDateFormat(pattern)
                time = simpleDateFormat.format(Date())
            }
        }

        Log.d("compose_test_project", "Iteration6: recomposing")

        Iteration6_TextDescriptor(
            modifier = Modifier.align(Alignment.Center),
            { Iteration6_Data }
        )

        Iteration6_Time(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 30.dp),
            time = { time }
        )

        Iteration6_TextUpdater(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 100.dp)
        ) {
            Iteration6_Data = Iteration6_Data.copy(
                id = Iteration6_Data.id + 1,
            )
        }
    }
}

@Composable
fun Iteration6_Time(modifier: Modifier, time: () -> String) {
    Log.d("compose_test_project", "Iteration6_Time: recomposing")
    Text(text = "Time is ${time()}", modifier = modifier)
}

@Composable
fun Iteration6_TextUpdater(modifier: Modifier, onUpdateText: () -> Unit) {
    Log.d("compose_test_project", "Iteration6_TextUpdater: recomposing")
    Button(
        onClick = onUpdateText,
        modifier = modifier
    ) {
        Text(text = "Update text!")
    }
}

@Composable
fun Iteration6_TextDescriptor(modifier: Modifier, Iteration6_Data: () -> Iteration6_Data) {
    Log.d("compose_test_project", "Iteration6_TextDescriptor: recomposing")
    Text(text = "Count is ${Iteration6_Data()}!", modifier = modifier)
}

@Stable
data class Iteration6_Data(
    val name: String = "",
    val id: Long = -1L,
    val stringSet: Set<String> = setOf()
)