package com.notesapp.model.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.notesapp.model.data.dao.NoteDao
import com.notesapp.model.entity.Converters
import com.notesapp.model.entity.Note

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