package com.example.composetest

import android.widget.Toast
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext

@Composable
fun StateLambda4(counter: () -> Counter) {
    val context = LocalContext.current
    val derivedCounter = remember {
        derivedStateOf { counter() }
    }
    Text(
        text = "count is ${derivedCounter.value}",
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        Toast.makeText(
                            context,
                            "counter value is ${derivedCounter.value}",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                )
            }
    )
}