package com.example.lockedin.ui.theme.Clock

import android.icu.text.DateFormat
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lockedin.states.ClockUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
class ClockViewModel: ViewModel(){
    private val _uiState = MutableStateFlow(ClockUiState())
    val uiState: StateFlow<ClockUiState> = _uiState.asStateFlow()

    init{
        viewModelScope.launch{
            while(true){
                 updateTime()
                delay(1000)
            }
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun updateTime(){
        val now = LocalTime.now()
        val hour12 = if(now.hour % 12 == 0) 12 else now.hour%12
        val  amPm =  if(now.hour>=12) "PM" else "AM"

        _uiState.value = _uiState.value.copy(
            hour = hour12,
            minute = now.minute,
            amPm = amPm
        )
    }
}

