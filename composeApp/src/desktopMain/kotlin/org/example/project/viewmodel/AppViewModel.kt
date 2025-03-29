package org.example.project.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.example.project.navigation.AppScreen

class AppViewModel {
    var currentScreen by mutableStateOf(AppScreen.Home)
        private set

    fun navigateTo(screen: AppScreen){
        currentScreen = screen
    }
}