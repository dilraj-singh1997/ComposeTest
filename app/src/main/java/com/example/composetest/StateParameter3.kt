package com.example.composetest

import android.util.Log
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember

@Composable
fun StateParameter3(counter: Counter) {
    val derivedCounter = remember(counter) {
        derivedStateOf { counter }
    }
    Text(text = "count is ${derivedCounter.value}")
    Text(text = "derived state is ${derivedCounter.hashCode()}")
}