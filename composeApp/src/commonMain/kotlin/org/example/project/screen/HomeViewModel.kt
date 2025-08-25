package org.example.project.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.data.API
import org.example.project.data.model.Person
import org.koin.android.annotation.KoinViewModel


class HomeViewModel constructor(
    private val api : API
) : ViewModel() {

    var showDialog by mutableStateOf(false)
    private val mutableListOfPerson = MutableStateFlow<List<Person>>(emptyList())
    val personList = mutableListOfPerson.asStateFlow()

    fun provideListOfPerson(){
        viewModelScope.launch {
           val list = api.getPerson()
            mutableListOfPerson.update { list }
        }
    }

    init {
        provideListOfPerson()
    }
}