package org.example.project.data

import org.example.project.data.model.Person

interface API {

    suspend fun getPerson() : List<Person>
}