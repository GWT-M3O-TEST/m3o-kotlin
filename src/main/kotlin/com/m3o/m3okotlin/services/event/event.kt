
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient
import com.m3o.m3okotlin.WebSocket

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "event"

object EventService {
    fun consume(name: String, messages: Int = 1, action: (Exception?, EventConsumeResponse?) -> Unit) {
        val url = getUrl(SERVICE, "Consume", true)
        WebSocket(url, Json.encodeToString(EventConsumeRequest(name, messages))) { e, response ->
            action(e, if (response != null) Json.decodeFromString(response) else null)
        }.connect()
    }
    suspend fun publish(name: String): EventPublishResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Publish")) {
          body = EventPublishRequest(name)
        }
    }
    suspend fun read(name: String): EventReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = EventReadRequest(name)
        }
    }
}
@Serializable
internal data class EventConsumeRequest(val topic: String, val group: String, val offset: String)
@Serializable
data class EventConsumeResponse(val id: String, val message: EventMap<String, dynamic>, val timestamp: String, val topic: String)
@Serializable
internal data class EventEv(val id: String, val message: EventMap<String, dynamic>, val timestamp: String)
@Serializable
internal data class EventPublishRequest(val message: EventMap<String, dynamic>, val topic: String)
@Serializable
data class EventPublishResponse()
@Serializable
internal data class EventReadRequest(val limit: Int, val offset: Int, val topic: String)
@Serializable
data class EventReadResponse(val events: List<EventEv>)
