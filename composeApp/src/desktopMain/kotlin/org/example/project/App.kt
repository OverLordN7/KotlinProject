package org.example.project

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.example.project.navigation.AppScreen
import org.example.project.screens.HomeScreen
import org.example.project.screens.SettingsScreen
import org.example.project.viewmodel.AppViewModel
import org.example.project.viewmodel.HomeViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val viewModel = remember { HomeViewModel() }
        val appViewModel = remember { AppViewModel() }

        Column {
            TopAppBar(
                title = { Text("My App") },
                actions = {
                    Button(onClick = { appViewModel.navigateTo(AppScreen.Home)}){
                        Text("Main")
                    }
                    Button(onClick = {appViewModel.navigateTo(AppScreen.Settings)}){
                        Text("Settings")
                    }
                }
            )

            when(appViewModel.currentScreen){
                AppScreen.Home -> HomeScreen(viewModel = viewModel)
                AppScreen.Settings -> SettingsScreen(onBack = {
                    appViewModel.navigateTo(AppScreen.Home)
                })
            }
        }
    }
}