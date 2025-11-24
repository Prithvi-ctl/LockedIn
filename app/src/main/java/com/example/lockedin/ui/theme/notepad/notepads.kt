package com.example.lockedin.ui.theme.notepad


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lockedin.R

import com.example.lockedin.model.NotepadModel.Note


@Composable
fun NotepadSurface() {
    val viewModel: NotepadViewModel = viewModel()
    val uiState by viewModel.notepadUiState.collectAsState()
    Column(modifier  = Modifier.fillMaxSize()) {
        NotepadAppBar()
        NotesIcon(modifier = Modifier,
            onClick = {viewModel.addNotes()})

        LazyColumn {
            items(uiState.NoteList) { note ->
                Notes(
                    note = note,
                    onTextChange ={newText -> viewModel.updateNotes(note.id,newText)},
                    onDelete = {viewModel.deleteNotes(note.id)}
                )
            }
        }
    }
}
@Composable
fun NotesIcon(modifier:Modifier = Modifier,
              onClick:() -> Unit) {


    Card(
        elevation = CardDefaults.cardElevation(),
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
        modifier =

        Modifier.padding(dimensionResource( R.dimen.medium_spacing))
        .clickable{
            onClick() }
    ) {
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
fun Notes(
    note: Note,
    onTextChange:(String) -> Unit,
    onDelete:() -> Unit
){
    Row(modifier = Modifier.fillMaxWidth()){
        TextField(
            value = note.text,
            onValueChange = onTextChange,
            placeholder= {Text("Type note.....")},
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = onDelete){
            Icon(Icons.Default.Delete, contentDescription = "Delete Note")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotepadAppBar(){
    TopAppBar(
        title = {Text("notihng")},
        modifier = Modifier

    )


}

@Preview
@Composable
fun Notes_Preview(){
NotepadSurface()
}

