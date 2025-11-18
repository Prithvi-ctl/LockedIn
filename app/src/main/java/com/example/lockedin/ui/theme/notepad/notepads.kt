package com.example.lockedin.ui.theme.notepad

import android.graphics.Color
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lockedin.R

fun notepadSurface(){

}
@Composable
fun addNotes(modifier:Modifier = Modifier,onClick:() -> Unit) {

    Card(
        elevation = CardDefaults.cardElevation(),
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        modifier =

        Modifier.padding(dimensionResource( R.dimen.medium_spacing)),
        onClick = {}) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth(),) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "add",
                modifier = modifier,


                )
            Text(
                text = stringResource(R.string.add_notes),
                modifier = modifier
            )
        }
    }
}


@Composable
fun Notes(){
    var text by remember { mutableStateOf("") }
    TextField(
value = text,
        onValueChange ={text = it},
        label = {Text("Example")},
        placeholder = {Text("Example")},
        singleLine = false,
        modifier = Modifier.fillMaxWidth()

    )
}

@Composable
fun deleteNotes(){

}
@Composable
fun editNotes(){

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun notepadAppBar(){
    TopAppBar(
        title = {Text("notihng")},
        modifier = Modifier

    )


}

@Preview
@Composable
fun Notes_Preview(){
    notepadAppBar()
}
