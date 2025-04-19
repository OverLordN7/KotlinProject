package org.example.project.model

import kotlinx.serialization.Serializable

@Serializable
data class Note(
    val id: Int,
    val title: String,
    val text:String,
    val createdAt: String,
    val colorHex: String = "#FFFFFF"
)