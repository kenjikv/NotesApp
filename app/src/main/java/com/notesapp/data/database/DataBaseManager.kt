package com.notesapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.notesapp.data.database.dao.NoteDao
import com.notesapp.data.entity.Converters
import com.notesapp.data.entity.Note

@Database(
    entities = [Note::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class DataBaseManager : RoomDatabase(){

    abstract fun noteDao(): NoteDao

    companion object {

        var INSTANCE: DataBaseManager? = null

        fun getAppDataBase(context: Context): DataBaseManager? {
            if (INSTANCE == null) {
                synchronized(DataBaseManager::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, DataBaseManager::class.java, "database").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase() {
            INSTANCE = null
        }
    }

}