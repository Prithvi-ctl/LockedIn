package com.example.lockedin.ui.theme.alarms

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AlarmScreen(modifier :Modifier = Modifier) {
    Box() {
        Column(
            modifier.fillMaxSize()
                .background(
                    color = MaterialTheme.colorScheme.background
                )
        )

        {
            AppBar()
            LazyColumn() {

            }
           
           
           
           
           
        }
        AddAlarmBtn(
            onClick= {},
            modifier = Modifier.
            align(Alignment.BottomEnd)
                .padding(30.dp),
       
        )

    }

}

@Composable
fun AddAlarmBtn(onClick :() -> Unit,modifier: Modifier ){
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
fun AlarmsList(){

}

@Composable
fun Sound(){

}

@Composable
fun Alarm(){

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


@Preview
@Composable
fun AlarmScene(){
         AlarmScreen()
    

}