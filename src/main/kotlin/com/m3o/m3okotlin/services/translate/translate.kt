
package com.m3o.m3okotlin.services.translate

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "translate"

object TranslateServ {
      suspend fun text(req: TranslateTextRequest): TranslateTextResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Text")) {
          body = req
        }
      }
}
@Serializable
data class TranslateTextRequest(val format: String? = null, val model: String? = null, val source: String? = null, val target: String? = null, val content: String? = null)
@Serializable
data class TranslateTextResponse(val translation: TranslateTranslation? = null)
@Serializable
data class TranslateTranslation(val model: String? = null, val source: String? = null, val text: String? = null)
