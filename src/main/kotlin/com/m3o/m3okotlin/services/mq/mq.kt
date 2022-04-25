
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient
import com.m3o.m3okotlin.WebSocket

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "mq"

object MqService {
    suspend fun publish(name: String): MqPublishResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Publish")) {
          body = MqPublishRequest(name)
        }
    }
    fun subscribe(name: String, messages: Int = 1, action: (Exception?, MqSubscribeResponse?) -> Unit) {
        val url = getUrl(SERVICE, "Subscribe", true)
        WebSocket(url, Json.encodeToString(MqSubscribeRequest(name, messages))) { e, response ->
            action(e, if (response != null) Json.decodeFromString(response) else null)
        }.connect()
    }
}
@Serializable
internal data class MqPublishRequest({/// The json message to publish
Map<String, dynamic>? message, /// The topic to publish to
String? topic,})
@Serializable
data class MqPublishResponse()
@Serializable
internal data class MqSubscribeRequest({/// The topic to subscribe to
String? topic,})
@Serializable
data class MqSubscribeResponse({/// The next json message on the topic
Map<String, dynamic>? message, /// The topic subscribed to
String? topic,})
