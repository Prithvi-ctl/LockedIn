package com.example.lockedin.ui.theme.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class liveTime {

    @RequiresApi(Build.VERSION_CODES.O)
    fun pullDeviceTime(): LocalTime {
        return LocalTime.now()
    }
}


@RequiresApi(Build.VERSION_CODES.O)
fun format12h(time:LocalTime):String{
    val formatter = DateTimeFormatter.ofPattern("hh:mm a")
    return time.format(formatter)
}

@RequiresApi(Build.VERSION_CODES.O)
fun parseTime(input:String):LocalTime{
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    return LocalTime.parse(input,formatter)
}