
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "spam"

object SpamService {
    suspend fun classify(name: String): SpamClassifyResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Classify")) {
          body = SpamClassifyRequest(name)
        }
    }
}
@Serializable
internal data class SpamClassifyRequest(val email_body: String, val from: String, val html_body: String, val subject: String, val text_body: String, val to: String)
@Serializable
data class SpamClassifyResponse(val details: List<SpamString>, val is_spam: Boolean, val score: Double)
