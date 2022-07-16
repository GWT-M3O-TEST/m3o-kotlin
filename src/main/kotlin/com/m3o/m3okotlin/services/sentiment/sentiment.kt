
package com.m3o.m3okotlin.services.sentiment

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "sentiment"

object SentimentService {
      suspend fun analyze(req: SentimentAnalyzeRequest): SentimentAnalyzeResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Analyze")) {
          body = req
        }
      }
}
@Serializable
data class SentimentAnalyzeRequest(val text: String, val lang: String)
@Serializable
data class SentimentAnalyzeResponse(val score: Double)
