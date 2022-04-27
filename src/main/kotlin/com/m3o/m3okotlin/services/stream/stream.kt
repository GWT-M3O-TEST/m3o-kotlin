
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
internal data class StreamChannel()
@Serializable
internal data class StreamCreateChannelRequest()
@Serializable
data class StreamCreateChannelResponse()
@Serializable
internal data class StreamListChannelsRequest()
@Serializable
data class StreamListChannelsResponse()
@Serializable
internal data class StreamListMessagesRequest()
@Serializable
data class StreamListMessagesResponse()
@Serializable
internal data class StreamMessage()
@Serializable
internal data class StreamSendMessageRequest()
@Serializable
data class StreamSendMessageResponse()
