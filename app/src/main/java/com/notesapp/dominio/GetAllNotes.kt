package com.notesapp.dominio

import android.content.Context
import com.notesapp.data.repository.NoteRepository
import com.notesapp.data.entity.Note

class GetAllNotes {

    var repository: NoteRepository

    constructor(context: Context) {
        this.repository = NoteRepository(context)
    }

    suspend operator fun invoke(): MutableList<Note> {
        return this.repository.getAll()
    }

}