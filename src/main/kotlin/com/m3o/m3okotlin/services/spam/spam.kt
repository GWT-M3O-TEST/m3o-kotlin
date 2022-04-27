
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
internal data class SpamClassifyRequest()
@Serializable
data class SpamClassifyResponse()
