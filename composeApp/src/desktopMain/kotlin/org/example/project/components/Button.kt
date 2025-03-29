package org.example.project.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ActionButton(label: String, onClick: () -> Unit){
    Button(onClick = onClick){
        Text(label)
    }
}