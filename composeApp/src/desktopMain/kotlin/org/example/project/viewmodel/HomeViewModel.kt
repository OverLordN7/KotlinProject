package org.example.project.viewmodel

import androidx.compose.runtime.mutableStateListOf
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

    fun addNote(text: String){
        if (text.isNotBlank()){
            val  note = Note(nextId++, text)
            notes.add(note)
            NoteStorage.saveNotes(notes)
        }
    }

    fun deleteNote(note: Note){
        notes.remove(note)
        NoteStorage.saveNotes(notes)
    }
}