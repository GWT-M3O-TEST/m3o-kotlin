
package com.m3o.m3okotlin.services.helloworld

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
    suspend fun call(req: HelloworldCallRequest): HelloworldCallResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Call")) {
          body = req
        }
    }
    fun stream(req: HelloworldStreamRequest, action: (Exception?, HelloworldStreamResponse?) -> Unit) {
        val url = getUrl(SERVICE, "Stream", true)
        WebSocket(url, Json.encodeToString(req)) { e, response ->
            action(e, if (response != null) Json.decodeFromString(response) else null)
        }.connect()
    }
}
@Serializable
data class HelloworldCallRequest(val name: String)
@Serializable
data class HelloworldCallResponse(val message: String)
@Serializable
data class HelloworldStreamRequest(val messages: Long, val name: String)
@Serializable
data class HelloworldStreamResponse(val message: String)
