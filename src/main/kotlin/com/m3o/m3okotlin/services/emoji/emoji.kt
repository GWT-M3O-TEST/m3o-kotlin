
package com.m3o.m3okotlin.services.emoji

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "emoji"

object EmojiService {
    suspend fun find(req: EmojiFindRequest): EmojiFindResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Find")) {
          body = req
        }
    }
    suspend fun flag(req: EmojiFlagRequest): EmojiFlagResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Flag")) {
          body = req
        }
    }
    suspend fun print(req: EmojiPrintRequest): EmojiPrintResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Print")) {
          body = req
        }
    }
}
@Serializable
data class EmojiFindRequest(val alias: String)
@Serializable
data class EmojiFindResponse(val emoji: String)
@Serializable
data class EmojiFlagRequest(val code: String)
@Serializable
data class EmojiFlagResponse(val flag: String)
@Serializable
data class EmojiPrintRequest(val text: String)
@Serializable
data class EmojiPrintResponse(val text: String)
