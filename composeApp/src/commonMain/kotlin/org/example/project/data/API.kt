package org.example.project.data

import org.example.project.data.model.Person
import org.example.project.data.model.Post

interface API {

    suspend fun getPerson() : List<Person>

    suspend fun getPost() : List<Post>

    suspend fun sendPost(post: Post) : Post
}