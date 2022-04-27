
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "sentiment"

object SentimentService {
    suspend fun analyze(name: String): SentimentAnalyzeResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Analyze")) {
          body = SentimentAnalyzeRequest(name)
        }
    }
}
@Serializable
internal data class SentimentAnalyzeRequest()
@Serializable
data class SentimentAnalyzeResponse()
