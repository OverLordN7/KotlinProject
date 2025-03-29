package org.example.project.storage

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.project.model.Note
import java.io.File


object NoteStorage{
    private val file = File(System.getProperty("user.dir"), "notes.json")

    fun saveNotes(notes: List<Note>){
        val json = Json.encodeToString(notes)
        file.writeText(json)
    }

    fun loadNotes(): List<Note>{
        return try{
            if (file.exists()){
                val json = file.readText()
                Json.decodeFromString(json)
            } else emptyList()
        } catch (e: Exception){
            println("Error in reading file: ${e.message}")
            emptyList()
        }
    }
}