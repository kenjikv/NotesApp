package com.notesapp.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notesapp.data.entity.Note
import com.notesapp.dominio.GetAllNotes
import com.notesapp.dominio.InsertNote
import com.notesapp.dominio.UpdateNote
import kotlinx.coroutines.launch

class NoteViewModel: ViewModel() {

    lateinit var getAllNotes: GetAllNotes
    lateinit var insertsNote: InsertNote
    lateinit var updatedNote: UpdateNote

    val loading = MutableLiveData<Boolean>()
    val resultInsertNote = MutableLiveData<Boolean>()
    val resultUpdateNote = MutableLiveData<Boolean>()
    val noteModel = MutableLiveData<Note>()
    val notesModel = MutableLiveData<MutableList<Note>>().apply { postValue(mutableListOf()) }

    fun init(context: Context) {
        this.getAllNotes = GetAllNotes(context)
        this.insertsNote = InsertNote(context)
        this.updatedNote = UpdateNote(context)
    }

    fun getNotes() {
        viewModelScope.launch {
            loading.postValue(true)
            notesModel.postValue(getAllNotes())
            loading.postValue(false)
        }
    }

    fun insertNote(note: Note) {
        viewModelScope.launch {
            loading.postValue(true)
            var result = insertsNote(note)
            resultInsertNote.postValue(result)
            loading.postValue(false)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            var result = updatedNote(note)
            resultUpdateNote.postValue(result)
        }
    }

}