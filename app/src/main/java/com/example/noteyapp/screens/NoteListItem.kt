package com.example.noteyapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteyapp.roomdb.Note


@Composable
fun NoteList(notes: Note) {

    Card (colors = CardDefaults.cardColors(
        containerColor = Color(notes.color)
    )){
        Column(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
            Text(text =notes.title, fontSize = 18.sp, fontWeight = FontWeight.W100)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = notes.description, fontSize = 18.sp, fontWeight = FontWeight.W100)
        }
    }

}

