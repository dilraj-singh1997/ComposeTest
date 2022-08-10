package com.example.composetest

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
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
fun Iteration3() {
    Box(modifier = Modifier.fillMaxSize()) {
        var iteration3_Data by remember {
            mutableStateOf(Iteration3_Data())
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

        Log.d("compose_test_project", "Iteration3: recomposing")

        Iteration3_TextDescriptor(
            modifier = Modifier.align(Alignment.Center),
            iteration3_Data
        )

        Iteration3_Time(
            modifier = Modifier
            .align(Alignment.TopCenter)
            .padding(top = 30.dp),
            time = time
        )

        Iteration3_TextUpdater(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 100.dp)
        ) {
            iteration3_Data = iteration3_Data.copy(
                id = iteration3_Data.id + 1,
            )
        }
    }
}

@Composable
fun Iteration3_Time(modifier: Modifier, time: String) {
    Log.d("compose_test_project", "Iteration3_Time: recomposing")
    Text(text = "Time is ${time}", modifier = modifier)
}

@Composable
fun Iteration3_TextUpdater(modifier: Modifier, onUpdateText: () -> Unit) {
    Log.d("compose_test_project", "Iteration3_TextUpdater: recomposing")
    Button(
        onClick = onUpdateText,
        modifier = modifier
    ) {
        Text(text = "Update text!")
    }
}

@Composable
fun Iteration3_TextDescriptor(modifier: Modifier, iteration3_Data: Iteration3_Data) {
    Log.d("compose_test_project", "Iteration3_TextDescriptor: recomposing")
    Text(text = "Count is ${iteration3_Data}!", modifier = modifier)
}

data class Iteration3_Data(
    var name: String = "",
    var id: Long = -1L
)
