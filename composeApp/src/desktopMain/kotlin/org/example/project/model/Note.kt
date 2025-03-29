package org.example.project.model

import kotlinx.serialization.Serializable

@Serializable
data class Note(
    val id: Int,
    val text:String
)