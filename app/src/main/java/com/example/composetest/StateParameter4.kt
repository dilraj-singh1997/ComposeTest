package com.example.composetest

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext

@Composable
fun StateParameter4(counter: Counter) {
    val derivedCounter = remember(counter) {
        derivedStateOf { counter }
    }
    Text(text = "count is ${derivedCounter.value}")
    Text(text = "derived state is ${derivedCounter.hashCode()}")
    DisposableEffect(Unit) {
        onDispose {
            Log.d(
                "debugdilraj",
                "dispose called with value $derivedCounter"
            )
        }
    }
}