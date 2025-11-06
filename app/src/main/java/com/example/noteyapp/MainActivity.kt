package com.example.noteyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.noteyapp.repository.NoteRepository
import com.example.noteyapp.roomdb.NoteDB
import com.example.noteyapp.ui.theme.NoteyAppTheme
import com.example.noteyapp.viewmodel.NoteViewModel
import com.example.noteyapp.viewmodel.NoteViewModelFactory
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.noteyapp.roomdb.Note
import com.example.noteyapp.screens.DisplayNoteList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //Room DB
        val database = NoteDB.getInstance(applicationContext)
        //Repository
        val repository = NoteRepository(database!!.notesDao)
        //ViewModelFactory
        val viewModelFactory = NoteViewModelFactory(repository)
        //ViewModelProvider
        val noteViewModel = ViewModelProvider(this, viewModelFactory).get(NoteViewModel::class.java)


        val note1= Note(
            id = 1,
            title = "Note 1",
            description = "This is note 1",
            color ="FF6200EE".toInt()
        )

        noteViewModel.insert(note1)


        setContent {
            NoteyAppTheme {

                val notes by noteViewModel.allNotes.observeAsState(emptyList())
                DisplayNoteList(notes)
            }
        }
    }
}




@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteyAppTheme {
        Greeting("Android")
    }
}