
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "stream"

object StreamService {
    suspend fun createChannel(name: String): StreamCreateChannelResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "CreateChannel")) {
          body = StreamCreateChannelRequest(name)
        }
    }
    suspend fun listChannels(name: String): StreamListChannelsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "ListChannels")) {
          body = StreamListChannelsRequest(name)
        }
    }
    suspend fun listMessages(name: String): StreamListMessagesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "ListMessages")) {
          body = StreamListMessagesRequest(name)
        }
    }
    suspend fun sendMessage(name: String): StreamSendMessageResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "SendMessage")) {
          body = StreamSendMessageRequest(name)
        }
    }
}
@Serializable
internal data class StreamChannel(val description: String, val last_active: String, val name: String)
@Serializable
internal data class StreamCreateChannelRequest(val description: String, val name: String)
@Serializable
data class StreamCreateChannelResponse()
@Serializable
internal data class StreamListChannelsRequest()
@Serializable
data class StreamListChannelsResponse(val channels: List<StreamChannel>)
@Serializable
internal data class StreamListMessagesRequest(val limit: Int, val channel: String)
@Serializable
data class StreamListMessagesResponse(val messages: List<StreamMessage>, val channel: String)
@Serializable
internal data class StreamMessage(val timestamp: String, val channel: String, val id: String, val metadata: Map<String, String>, val text: String)
@Serializable
internal data class StreamSendMessageRequest(val channel: String, val text: String)
@Serializable
data class StreamSendMessageResponse()
