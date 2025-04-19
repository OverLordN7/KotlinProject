package org.example.project.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.example.project.model.Note
import org.example.project.storage.NoteStorage

class HomeViewModel(
    private val noteStorage: NoteStorage
) {
    private var nextId = 1
    private val _notes = mutableStateListOf<Note>()
    val notes: List<Note> get() = _notes

    var searchQuery by mutableStateOf("")
        private set

    val filteredNotes: List<Note>
        get() = if (searchQuery.isBlank()) _notes
                else _notes.filter {
                    it.title.contains(searchQuery, ignoreCase = true) ||
                            it.text.contains(searchQuery, ignoreCase = true)
        }

    init {
        _notes.addAll(noteStorage.loadNotes())
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
            _notes.add(note)
            noteStorage.saveNotes(notes)
        }
    }

    fun deleteNote(note: Note){
        _notes.remove(note)
        noteStorage.saveNotes(notes)
    }

    fun updateSearchQuery(query: String){
        searchQuery = query
    }
}