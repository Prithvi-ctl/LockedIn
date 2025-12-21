package com.example.lockedin.ui.theme.alarms

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.lockedin.model.NotepadModel.alarmModel
import com.example.lockedin.states.alarmsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class alarmsViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(alarmsUiState())
    val alarmsUiState: StateFlow<alarmsUiState> = _uiState.asStateFlow()

    fun setHour(value:Int){
        _uiState.update{it.copy(hour= value)}
    }
    fun setMinutes(value:Int){
        _uiState.update{it.copy(minutes = value)}
    }

    fun addAlarms(){
        _uiState.update{currentState ->
            val newId = (currentState.AlarmList.maxOfOrNull {it.id} ?: 0)+1
            val newAlarm = alarmModel(id= newId,Time = "${currentState.hour}:${currentState.minutes}" )
            currentState.copy(AlarmList = currentState.AlarmList + newAlarm)
        }
    }



}