
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
internal data class EventConsumeRequest({/// Optional group for the subscription
String? group, /// Optional offset to read from e.g "2006-01-02T15:04:05.999Z07:00"
String? offset, /// The topic to subscribe to
String? topic,})
@Serializable
data class EventConsumeResponse({/// Timestamp of publishing
String? timestamp, /// The topic subscribed to
String? topic, /// Unique message id
String? id, /// The next json message on the topic
Map<String, dynamic>? message,})
@Serializable
internal data class EventEv({/// event id
String? id, /// event message
Map<String, dynamic>? message, /// event timestamp
String? timestamp,})
@Serializable
internal data class EventPublishRequest({/// The json message to publish
Map<String, dynamic>? message, /// The topic to publish to
String? topic,})
@Serializable
data class EventPublishResponse()
@Serializable
internal data class EventReadRequest({/// number of events to read; default 25
int? limit, /// offset for the events; default 0
int? offset, /// topic to read from
String? topic,})
@Serializable
data class EventReadResponse({/// the events
List<Ev>? events,})
