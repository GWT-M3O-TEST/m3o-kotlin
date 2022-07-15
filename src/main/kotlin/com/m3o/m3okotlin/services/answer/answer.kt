
package com.m3o.m3okotlin.services.answer

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "answer"

object AnswerService {
      suspend fun question(req: AnswerQuestionRequest): AnswerQuestionResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Question")) {
          body = req
        }
      }
}
@Serializable
data class AnswerQuestionRequest(val query: String)
@Serializable
data class AnswerQuestionResponse(val image: String, val url: String, val answer: String)
