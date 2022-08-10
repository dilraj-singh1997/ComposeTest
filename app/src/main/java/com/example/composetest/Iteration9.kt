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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
@Composable
fun Iteration9() {
    Box(modifier = Modifier.fillMaxSize()) {
        val stateFlow = remember {
            MutableStateFlow(Iteration9_Data())
        }

        val Iteration9_Data by stateFlow.collectAsState()

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

        Log.d("compose_test_project", "Iteration9: recomposing")

        Iteration9_TextDescriptor(
            modifier = Modifier.align(Alignment.Center),
            { Iteration9_Data }
        )

        Iteration9_Time(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 30.dp),
            time = { time }
        )

        val updater = remember {
            {
                stateFlow.update {
                    it.copy(
                        id = Iteration9_Data.id + 1,
                    )
                }
            }
        }

        Iteration9_TextUpdater(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 100.dp),
            onUpdateText = updater
        )
    }
}

@Composable
fun Iteration9_Time(modifier: Modifier, time: () -> String) {
    Log.d("compose_test_project", "Iteration9_Time: recomposing")
    Text(text = "Time is ${time()}", modifier = modifier)
}

@Composable
fun Iteration9_TextUpdater(modifier: Modifier, onUpdateText: () -> Unit) {
    Log.d("compose_test_project", "Iteration9_TextUpdater: recomposing")
    Button(
        onClick = onUpdateText,
        modifier = modifier
    ) {
        Text(text = "Update text!")
    }
}

@Composable
fun Iteration9_TextDescriptor(modifier: Modifier, Iteration9_Data: () -> Iteration9_Data) {
    Log.d("compose_test_project", "Iteration9_TextDescriptor: recomposing")
    Text(text = "Count is ${Iteration9_Data()}!", modifier = modifier)
}

@Stable
data class Iteration9_Data(
    val name: String = "",
    val id: Long = -1L,
    val stringSet: Set<String> = setOf()
)
