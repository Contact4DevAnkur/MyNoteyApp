package com.example.noteyapp.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database (entities = [Note::class], version = 1)
abstract  class NoteDB : RoomDatabase() {
    abstract  val notesDao: NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NoteDB? = null
        fun getInstance(context: Context): NoteDB? {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {

                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDB::class.java,
                        "note_database"
                    ).build()
                }

            }
            return INSTANCE
        }
    }
}