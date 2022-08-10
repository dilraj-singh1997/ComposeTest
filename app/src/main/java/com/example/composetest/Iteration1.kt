package com.example.composetest

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Iteration1() {
    Box(modifier = Modifier.fillMaxSize()) {
        var count by remember {
            mutableStateOf(0)
        }

        Log.d("compose_test_project", "Iteration1: recomposing")

        Iteration1_TextDescriptor(
            modifier = Modifier.align(Alignment.Center),
            count
        )

        Iteration1_TextUpdater(
            modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 100.dp)
        ) {
            count += 1
        }
    }
}

@Composable
fun Iteration1_TextUpdater(modifier: Modifier, onUpdateText: () -> Unit) {
    Log.d("compose_test_project", "Iteration1_TextUpdater: recomposing")
    Button(
        onClick = onUpdateText,
        modifier = modifier
    ) {
        Text(text = "Update text!")
    }
}

@Composable
fun Iteration1_TextDescriptor(modifier: Modifier, count: Int) {
    Log.d("compose_test_project", "Iteration1_TextDescriptor: recomposing")
    Text(text = "Count is $count!", modifier = modifier)
}