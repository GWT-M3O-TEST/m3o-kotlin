
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
internal data class SentimentAnalyzeRequest({/// The language. Defaults to english.
String? lang, /// The text to analyze
String? text,})
@Serializable
data class SentimentAnalyzeResponse({/// The score of the text {positive is 1, negative is 0}
double? score,})
