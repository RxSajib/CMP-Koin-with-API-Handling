package org.example.project.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class HomeViewModel : ViewModel() {

    var showDialog by mutableStateOf(false)
}