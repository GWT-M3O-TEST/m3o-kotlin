
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "translate"

object TranslateService {
    suspend fun text(name: String): TranslateTextResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Text")) {
          body = TranslateTextRequest(name)
        }
    }
}
@Serializable
internal data class TranslateTextRequest(val format: String, val model: String, val source: String, val target: String, val content: String)
@Serializable
data class TranslateTextResponse(val translation: TranslateTranslation)
@Serializable
internal data class TranslateTranslation(val text: String, val model: String, val source: String)
