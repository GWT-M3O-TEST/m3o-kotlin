
package com.m3o.m3okotlin.services.spam

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "spam"

object SpamServ {
      suspend fun classify(req: SpamClassifyRequest): SpamClassifyResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Classify")) {
          body = req
        }
      }
}
@Serializable
data class SpamClassifyRequest(val email_body: String? = null, val from: String? = null, val html_body: String? = null, val subject: String? = null, val text_body: String? = null, val to: String? = null)
@Serializable
data class SpamClassifyResponse(val details: List<String>? = null, val is_spam: Boolean? = null, val score: Double? = null)
