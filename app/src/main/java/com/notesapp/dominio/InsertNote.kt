package com.notesapp.dominio

import android.content.Context
import com.notesapp.data.entity.Note
import com.notesapp.data.repository.NoteRepository

class InsertNote {

    var repository: NoteRepository

    constructor(context: Context) {
        this.repository = NoteRepository(context)
    }

    suspend operator fun invoke(note: Note): Boolean {
        return this.repository.insert(note)
    }
}