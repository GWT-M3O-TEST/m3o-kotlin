
package com.m3o.m3okotlin.services.translate

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "translate"

object TranslateService {
    suspend fun text(req: TranslateTextRequest): TranslateTextResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Text")) {
          body = req
        }
    }
}
@Serializable
data class TranslateTextRequest(val model: String, val source: String, val target: String, val content: String, val format: String)
@Serializable
data class TranslateTextResponse(val translation: TranslateTranslation)
@Serializable
data class TranslateTranslation(val source: String, val text: String, val model: String)
