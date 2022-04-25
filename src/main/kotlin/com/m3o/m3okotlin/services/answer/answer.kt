
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "answer"

object AnswerService {
    suspend fun question(name: String): AnswerQuestionResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Question")) {
          body = AnswerQuestionRequest(name)
        }
    }
}
@Serializable
internal data class AnswerQuestionRequest({/// the question to answer
String? query,})
@Serializable
data class AnswerQuestionResponse({/// a related url
String? url, /// the answer to your question
String? answer, /// any related image
String? image,})
