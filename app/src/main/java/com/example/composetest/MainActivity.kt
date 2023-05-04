package com.example.composetest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.collect

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                var counter by remember {
                    mutableStateOf(Counter(1))
                }

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = {
                        counter = counter.copy(intValue = counter.intValue + 1)
                    }
                ) {
                    Text(text = "increase count")
                }

                Spacer(modifier = Modifier.height(20.dp))

                StateParameter1(counter = counter)
            }
        }
    }
}
