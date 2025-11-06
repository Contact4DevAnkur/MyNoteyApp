package com.example.noteyapp.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface NoteDao {

    @Insert
     fun insert(note: Note)

    @Query("Select * from note_table")
     fun getAllNotes(): LiveData<List<Note>>



}