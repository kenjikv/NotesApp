package com.notesapp.data.repository

import android.content.Context
import com.notesapp.data.database.DataBaseManager
import com.notesapp.data.database.dao.NoteDao
import com.notesapp.data.entity.Note

class NoteRepository(context: Context) {

    private lateinit var noteDao: NoteDao

    init {
        var db = DataBaseManager.getAppDataBase(context)
        this.noteDao = db!!.noteDao()
    }

    suspend fun getAll(): MutableList<Note> {
        return noteDao.getAll()
    }

    suspend fun insert(note: Note): Boolean {
        noteDao.insert(note)
        return true
    }

    suspend fun update(note: Note): Boolean {
        noteDao.update(note)
        return true
    }
}