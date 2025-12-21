package com.example.lockedin.ui.theme.alarms

import android.R
import android.graphics.Canvas
import android.graphics.Paint
import android.widget.NumberPicker
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lockedin.model.NotepadModel.alarmModel
import org.intellij.lang.annotations.JdkConstants

@Composable
fun AlarmScreen(modifier :Modifier = Modifier) {
    val viewModel:alarmsViewModel = viewModel()
    val uiState by viewModel.alarmsUiState.collectAsState()
    var showDialog by remember { mutableStateOf(false) }
    Box() {
        Column(
            modifier
                .fillMaxSize()
                .background(
                    color = MaterialTheme.colorScheme.background
                )
        )
        {
            AppBar()
            AlarmText(modifier = Modifier,
                )
            LazyColumn {

                items(uiState.AlarmList) { alarm ->
                    simpleAlarmShowcase(
                        alarm

                    )
                           }
            }
        }
        AddAlarmBtn(
            onClick= {showDialog = true},

            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(30.dp),
        )
        if(showDialog){

            Dialogue (uiState.hour,
                uiState.minutes,
                onDismiss = {showDialog = false
                        viewModel.addAlarms()},
                onHourChange = {viewModel.setHour(it)},
                onMinuteChange = {viewModel.setMinutes(it)}
                        )
        }
    }
}

@Composable
fun AddAlarmBtn(onClick : () -> Unit, modifier: Modifier ){
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier
            .size(56.dp)
            .background(
                color = MaterialTheme.colorScheme.secondary,
                shape = CircleShape

            )

    ) {
        Icon(
            imageVector = Icons.Default.Add ,
            contentDescription = "Add",
            tint = Color.White
        )
    }
}


@Composable
fun AlarmText(modifier: Modifier){
      Text("Add Alarms")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(){
    CenterAlignedTopAppBar(
            title = { Text("Alarms") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor  = MaterialTheme.colorScheme.onPrimary))

}

@Composable
fun Dialogue(hour:Int,
             minutes:Int,
             onDismiss: () -> Unit,
             onHourChange :(Int) -> Unit,
             onMinuteChange :(Int) -> Unit) {


        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("Set Alarms") }
            ,
            text = {
            Row(){
                NumberPicker(hour,0..12, onValueChange = onHourChange)

                NumberPicker(minutes,range=0..59, onValueChange = onMinuteChange)
            }},
            confirmButton = {
                Button(onClick = onDismiss) {
                    Text("OK")
                }
            }
        )

}

@Composable
fun NumberPicker(
    value :Int,
    range:IntRange,
    onValueChange:(Int) ->Unit
){
    var expanded by remember {mutableStateOf(false)}

    Box{
        TextButton(onClick = {expanded = true}){
            Text(text = value.toString().padStart(2,'0'),
            fontSize = 20.sp)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {expanded=false}
        ) {
            range.forEach{
                DropdownMenuItem(
                    text = {Text(it.toString().padStart(length = 2,padChar = '0'))},
                    onClick = {
                        onValueChange(it)
                        expanded= false
                    }
                )
            }
        }
    }
}

@Composable
fun simpleAlarmShowcase(alarm: alarmModel){
    Card(elevation = CardDefaults.cardElevation(),
        shape = RoundedCornerShape(10.dp)
    ){
        Text(alarm.Time)
    }
}



@Preview
@Composable
fun AlarmScene(){
AlarmScreen()


}