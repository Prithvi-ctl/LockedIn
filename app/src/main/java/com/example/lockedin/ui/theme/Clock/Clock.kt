package com.example.lockedin.ui.theme.Clock

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel



class Clock {
    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    fun Tim() {
       val viewModel:ClockViewModel = viewModel()
        val uiState by viewModel.uiState.collectAsState()
        Box(contentAlignment = Alignment.Center,modifier = Modifier.fillMaxSize()
           ) {
            Text(
                text = "${uiState.hour}:${uiState.minute.toString().padStart(2,'0')}" +
                        "${uiState.amPm}",
                fontSize = 32.sp

            )
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    @Preview
    @Composable
    fun Screen() {
        Tim()
    }
}
