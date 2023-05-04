package com.example.composetest

import android.util.Log
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember

@Composable
fun StateLambda3(counter: () -> Counter) {
    val derivedCounter = remember {
        derivedStateOf { counter().intValue % 10 == 0 }
    }
    Log.d(
        "debugdilraj",
        "recomposing parent"
    )
    Text(text = "count is ${derivedCounter.value}")
    Text(text = "derived state is ${derivedCounter.hashCode()}")
    Child(counter)
    DisposableEffect(Unit) {
        onDispose {
            Log.d(
                "debugdilraj",
                "dispose called with value ${counter()}"
            )
        }
    }
}

@Composable
fun Child(counter: () -> Counter) {
    Log.d(
        "debugdilraj",
        "recomposing child"
    )
    Text(text = "child counter is ${counter()}")
}