package org.example.project.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.model.Note

@Composable
fun NoteItem(
    note: Note,
    onDelete: (Note) -> Unit,
    modifier: Modifier = Modifier
){
    val backgroundColor = remember(note.colorHex) { hexToColor(note.colorHex) }

    Card (
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        backgroundColor = backgroundColor,
        elevation = 4.dp
    ){
        Column(modifier = modifier.padding(12.dp)){
            Text(note.title, fontWeight = FontWeight.Bold)
            Text(note.text)
            Text("Created: ${note.createdAt}", fontSize = 12.sp, color = Color.DarkGray)
            Spacer(modifier = modifier.height(8.dp))
            Button(onClick = { onDelete(note)}){
                Text("Delete")
            }
        }
    }
}

fun hexToColor(hex: String): Color {
    val colorInt = hex.removePrefix("#").toLong(16).toInt()
    return Color(colorInt or 0xFF000000.toInt()) // Принудительно устанавливаем alpha = 255
}