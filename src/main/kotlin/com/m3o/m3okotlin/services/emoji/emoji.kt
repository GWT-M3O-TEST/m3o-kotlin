
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "emoji"

object EmojiService {
    suspend fun find(name: String): EmojiFindResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Find")) {
          body = EmojiFindRequest(name)
        }
    }
    suspend fun flag(name: String): EmojiFlagResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Flag")) {
          body = EmojiFlagRequest(name)
        }
    }
    suspend fun print(name: String): EmojiPrintResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Print")) {
          body = EmojiPrintRequest(name)
        }
    }
}
@Serializable
internal data class EmojiFindRequest()
@Serializable
data class EmojiFindResponse()
@Serializable
internal data class EmojiFlagRequest()
@Serializable
data class EmojiFlagResponse()
@Serializable
internal data class EmojiPrintRequest()
@Serializable
data class EmojiPrintResponse()
