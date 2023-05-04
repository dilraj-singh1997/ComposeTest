package com.example.composetest

import android.widget.Toast
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext

@Composable
fun StateLambda5(counter: () -> Counter) {
    val context = LocalContext.current
    Text(
        text = "count is ${counter()}",
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        Toast
                            .makeText(
                                context,
                                "counter value is ${counter()}",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                )
            }
    )
}