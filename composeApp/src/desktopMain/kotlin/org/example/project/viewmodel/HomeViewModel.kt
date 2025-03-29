package org.example.project.viewmodel

import androidx.compose.runtime.mutableStateListOf
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.example.project.model.Note
import org.example.project.storage.NoteStorage

class HomeViewModel {
    private var nextId = 1
    var notes = mutableStateListOf<Note>()
        private set

    init {
        notes.addAll(NoteStorage.loadNotes())
        nextId = (notes.maxOfOrNull { it.id } ?: 0) + 1
    }

    fun addNote(title: String, text: String){
        if (text.isNotBlank()){
            val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
            val formatted = "${now.date} ${now.time.hour}:${now.time.minute.toString().padStart(2,'0')}"
            val  note = Note(
                id = nextId++,
                title = title.ifBlank { "No title" },
                text = text,
                createdAt = formatted,
                colorHex = listOf("#FFEBEE", "#E3F2FD", "#E8F5E9", "#FFFDE7").random()
            )
            notes.add(note)
            NoteStorage.saveNotes(notes)
        }
    }

    fun deleteNote(note: Note){
        notes.remove(note)
        NoteStorage.saveNotes(notes)
    }
}