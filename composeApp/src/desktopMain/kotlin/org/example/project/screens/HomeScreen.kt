package org.example.project.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.components.NoteItem
import org.example.project.viewmodel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel, modifier: Modifier = Modifier){
    var title by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        Text("New note", fontSize = 18.sp)

        TextField(
            value = title,
            onValueChange = { title = it},
            label = {Text("Title")},
            modifier = modifier.fillMaxWidth()
        )

        Spacer(modifier = modifier.width(8.dp))

        TextField(
            value = text,
            onValueChange = { text = it},
            label = { Text("Text") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = modifier.width(8.dp))

        Button(onClick = {
            viewModel.addNote(title, text)
            title=""
            text = ""
        }){
            Text("Add")
        }

        Spacer(modifier = modifier.height(16.dp))

        LazyColumn{
            items(viewModel.notes) { note->
                NoteItem(note = note, onDelete = {viewModel.deleteNote(it)})
            }
        }
    }
}