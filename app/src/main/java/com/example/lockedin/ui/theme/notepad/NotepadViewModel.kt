package com.example.lockedin.ui.theme.notepad

import androidx.lifecycle.ViewModel
import com.example.lockedin.States.NotepadUiState
import com.example.lockedin.model.NotepadModel.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NotepadViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(NotepadUiState())
    val notepadUiState: StateFlow<NotepadUiState> = _uiState.asStateFlow()



    fun addNotes(){
        _uiState.update{currentState ->
            val newNote = Note(id = currentState.NoteList.size + 1)
            currentState.copy(NoteList = currentState.NoteList + newNote)

        }
    }
    fun updateNotes(id:Int,newText:String){
        _uiState.update{currentState->
            val updatedNotes = currentState.NoteList.map{
                note->
                if(note.id == id) note.copy(text = newText) else note
            }
            currentState.copy(NoteList = updatedNotes)

        }
    }
    fun deleteNotes(id:Int){
        _uiState.update { currentState ->
            currentState.copy(NoteList = currentState.NoteList.filter{it.id != id})

        }
    }

}