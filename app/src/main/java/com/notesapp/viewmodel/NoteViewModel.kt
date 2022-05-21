package com.notesapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.notesapp.model.data.NoteProvider
import com.notesapp.model.entity.Note

class NoteViewModel: ViewModel() {

    val noteModel = MutableLiveData<Note>()
    val notesModel = MutableLiveData<MutableList<Note>>().apply { postValue(mutableListOf()) }

    fun getNotes() {
        notesModel.postValue(NoteProvider.getNotes())
    }

}