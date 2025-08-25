package org.example.project.data

import org.example.project.data.model.Person
import org.example.project.data.model.listOfPerson

class APIResponse : API {
    override suspend fun getPerson(): List<Person> {
        return listOfPerson
    }
}