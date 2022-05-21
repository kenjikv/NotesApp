package com.notesapp.model.data.dao

import androidx.room.*
import com.notesapp.model.entity.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes_table")
    suspend fun getAll(): List<Note>

    @Query("SELECT * FROM notes_table WHERE id = :id")
    suspend fun getById(id: Int): Note

    @Update
    suspend fun update(note: Note)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(notes: List<Note>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)
}