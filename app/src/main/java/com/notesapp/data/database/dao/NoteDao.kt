package com.notesapp.data.database.dao

import androidx.room.*
import com.notesapp.data.entity.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes_table")
    suspend fun getAll(): MutableList<Note>

    @Query("SELECT * FROM notes_table WHERE id = :id")
    suspend fun getById(id: Int): Note

    @Update
    suspend fun update(note: Note)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(notes: MutableList<Note>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)
}