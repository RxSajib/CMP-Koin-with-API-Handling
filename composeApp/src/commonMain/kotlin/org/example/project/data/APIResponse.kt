package org.example.project.data

import io.ktor.client.HttpClient
import org.example.project.data.model.Person
import org.example.project.data.model.listOfPerson

class APIResponse (
  //  private val httpClient: HttpClient
) : API {
    override suspend fun getPerson(): List<Person> {
        return listOfPerson
    }
}