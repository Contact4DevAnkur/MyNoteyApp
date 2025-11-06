package com.example.noteyapp.repository

import com.example.noteyapp.roomdb.Note
import com.example.noteyapp.roomdb.NoteDao

class NoteRepository  (private val noteDao: NoteDao) {
    val allNotes = noteDao.getAllNotes()

     fun insert(note: Note) {
        noteDao.insert(note)
    }

}