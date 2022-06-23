
package com.m3o.m3okotlin.services.event

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
      fun consume(req: EventConsumeRequest, action: (Exception?, EventConsumeResponse?) -> Unit) {
          val url = getUrl(SERVICE, "Consume", true)
          WebSocket(url, Json.encodeToString(req)) { e, response ->
              action(e, if (response != null) Json.decodeFromString(response) else null)
          }.connect()
      }
      suspend fun publish(req: EventPublishRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "Publish")) {
          body = req
        }
      }
      suspend fun read(req: EventReadRequest): EventReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = req
        }
      }
}
@Serializable
data class EventConsumeRequest(val offset: String, val topic: String, val group: String)
@Serializable
data class EventConsumeResponse(val id: String, val message: EventMap<String, dynamic>, val timestamp: String, val topic: String)
@Serializable
data class EventEv(val timestamp: String, val id: String, val message: EventMap<String, dynamic>)
@Serializable
data class EventPublishRequest(val topic: String, val message: EventMap<String, dynamic>)
@Serializable
data class EventReadRequest(val topic: String, val limit: Int, val offset: Int)
@Serializable
data class EventReadResponse(val events: List<EventEv>)
