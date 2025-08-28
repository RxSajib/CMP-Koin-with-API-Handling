package org.example.project.data

import androidx.compose.ui.autofill.ContentType
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType.Application.Json
import io.ktor.http.contentType
import io.ktor.http.path
import kotlinx.serialization.json.Json
import org.example.project.data.model.Person
import org.example.project.data.model.Post
import org.example.project.data.model.listOfPerson

class APIResponse(
    private val httpClient: HttpClient
) : API {
    override suspend fun getPerson(): List<Person> {
        return listOfPerson
    }

    override suspend fun getPost(): List<Post> {
        try {
            val response = httpClient.get("/posts")
            Napier.v("SuccessCode ${response.status.value}")
            if (response.status.value == 200) {
                Napier.v("HTTP ${response.status.value}, CT=${response.headers["Content-Type"]}")


                val raw = response.bodyAsText()
                Napier.v("Raw body (first 300 chars): ${raw.take(300)}")

                val posts = Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    coerceInputValues = true
                }.decodeFromString<List<Post>>(raw)

                Napier.v("Parsed ${posts} posts")

                //  val posts: List<Post> = response.body<List<Post>>()

                /* val posts: List<Post> = response
                     .body()*/
                //    Napier.v("SuccessCode Call ${response.body<List<Post>>()}")

                return posts
            } else {
                return emptyList()
            }
        } catch (e: Exception) {
            Napier.e("Error", e)
            Napier.v("ErrorHandle ${e.message.toString()}")
            return emptyList()
        }
    }

    override suspend fun sendPost(post: Post): Post {
        val response = httpClient.post {
            url { path("/posts") }
            contentType(type = Json)
            setBody(post)
        }

        val raw = response.bodyAsText()
        val posts = Json {
            ignoreUnknownKeys = true
            isLenient = true
            coerceInputValues = true
        }.decodeFromString<Post>(raw)

        Napier.v("Parsed $posts")
        return posts
    }
}