package com.example.composetest

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember

@Composable
fun StateParameter2(counter: Counter) {
    val derivedCounter = remember {
        derivedStateOf { counter }
    }
    Text(text = "count is ${derivedCounter.value}")
    Text(text = "derived state is ${derivedCounter.hashCode()}")
}