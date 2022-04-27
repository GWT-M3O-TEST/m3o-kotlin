
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient
import com.m3o.m3okotlin.WebSocket

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "helloworld"

object HelloworldService {
    suspend fun call(name: String): HelloworldCallResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Call")) {
          body = HelloworldCallRequest(name)
        }
    }
    fun stream(name: String, messages: Int = 1, action: (Exception?, HelloworldStreamResponse?) -> Unit) {
        val url = getUrl(SERVICE, "Stream", true)
        WebSocket(url, Json.encodeToString(HelloworldStreamRequest(name, messages))) { e, response ->
            action(e, if (response != null) Json.decodeFromString(response) else null)
        }.connect()
    }
}
@Serializable
internal data class HelloworldCallRequest()
@Serializable
data class HelloworldCallResponse()
@Serializable
internal data class HelloworldStreamRequest()
@Serializable
data class HelloworldStreamResponse()
