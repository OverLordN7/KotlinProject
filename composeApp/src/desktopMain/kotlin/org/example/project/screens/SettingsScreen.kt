package org.example.project.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen(onBack: ()-> Unit, modifier: Modifier = Modifier){
    Column(modifier = modifier.padding(16.dp)){
        Text(
            text = "Settings",
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp),
        )
        Text("Here you can add parameters of the app")
        Spacer(Modifier.height(16.dp))
        Button(onClick = onBack){
            Text("Back")
        }
    }
}