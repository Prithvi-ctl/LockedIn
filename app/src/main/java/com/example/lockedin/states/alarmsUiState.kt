package com.example.lockedin.states

import com.example.lockedin.model.NotepadModel.alarmModel

data class alarmsUiState(

    val AlarmList: List<alarmModel> = emptyList(),
    val hour:Int = 0,
    val minutes:Int =0,


    )