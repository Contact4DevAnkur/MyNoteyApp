package com.example.noteyapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.noteyapp.repository.NoteRepository
import com.example.noteyapp.roomdb.Note

class NoteViewModel(private  val repository: NoteRepository): ViewModel() {


    val allNotes = repository.allNotes

     fun insert(note: Note) {
        repository.insert(note)
    }



}