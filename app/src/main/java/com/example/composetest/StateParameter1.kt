package com.example.composetest

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun StateParameter1(counter: Counter) {
    Text(text = "count is $counter")
}
