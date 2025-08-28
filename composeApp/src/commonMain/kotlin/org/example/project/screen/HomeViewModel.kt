package org.example.project.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.data.API
import org.example.project.data.model.Person
import org.example.project.data.model.Post
import org.koin.android.annotation.KoinViewModel


class HomeViewModel constructor(
    private val api : API
) : ViewModel() {

    var showDialog by mutableStateOf(false)
    private val mutableListOfPerson = MutableStateFlow<List<Person>>(emptyList())
    val personList = mutableListOfPerson.asStateFlow()

    var isProgress by mutableStateOf(false)

    fun provideListOfPerson(){
        viewModelScope.launch {
           val list = api.getPerson()
            mutableListOfPerson.update { list }
        }
    }

    init {
        provideListOfPerson()
        getPost()
    }

    private val _postMutableStateFlow = MutableStateFlow<List<Post>>(emptyList())
    val post = _postMutableStateFlow.asStateFlow()
    fun getPost(){
        viewModelScope.launch {
            isProgress = true
            val post = api.getPost()
            isProgress = false
            _postMutableStateFlow.update {post}
            Napier.v("MyData ${api.getPost()}")

        }
    }


    private val _mutableStateFlowFlowResponse = MutableSharedFlow<Post>()
    val mutableStateFlowFlowResponse = _mutableStateFlowFlowResponse.asSharedFlow()
    fun sendPost(post: Post){
        viewModelScope.launch {
            isProgress = true
            val postResponse = api.sendPost(post = post)
            _mutableStateFlowFlowResponse.emit(postResponse)
            isProgress = false
        }
    }
}