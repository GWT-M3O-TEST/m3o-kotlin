
package com.m3o.m3okotlin.services.answer

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "answer"

object AnswerServ {
      suspend fun question(req: AnswerQuestionRequest): AnswerQuestionResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Question")) {
          body = req
        }
      }
}
@Serializable
data class AnswerQuestionRequest(val query: String)
@Serializable
data class AnswerQuestionResponse(val url: String, val answer: String, val image: String)
