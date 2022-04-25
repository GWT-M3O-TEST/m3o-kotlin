
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
internal data class EmojiFindRequest({/// the alias code e.g :beer:
String? alias,})
@Serializable
data class EmojiFindResponse({/// the unicode emoji 🍺
String? emoji,})
@Serializable
internal data class EmojiFlagRequest({/// country code e.g GB
String? code,})
@Serializable
data class EmojiFlagResponse({/// the emoji flag
String? flag,})
@Serializable
internal data class EmojiPrintRequest({/// text including any alias e.g let's grab a :beer:
String? text,})
@Serializable
data class EmojiPrintResponse({/// text with rendered emojis
String? text,})
