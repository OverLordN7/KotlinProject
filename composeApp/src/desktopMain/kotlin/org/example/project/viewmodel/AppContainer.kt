package org.example.project.viewmodel

import org.example.project.storage.NoteStorage

class AppContainer {
    val noteStorage: NoteStorage by lazy { NoteStorage }

    // ViewModels
    val homeViewModel: HomeViewModel by lazy {
        HomeViewModel(noteStorage)
    }

    val appViewModel: AppViewModel by lazy {
        AppViewModel()
    }
}