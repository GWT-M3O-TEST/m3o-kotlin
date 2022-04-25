
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
internal data class StreamChannel({/// description for the channel
String? description, /// last activity time
String? last_active, /// name of the channel
String? name,})
@Serializable
internal data class StreamCreateChannelRequest({/// description for the channel
String? description, /// name of the channel
String? name,})
@Serializable
data class StreamCreateChannelResponse()
@Serializable
internal data class StreamListChannelsRequest()
@Serializable
data class StreamListChannelsResponse({List<Channel>? channels,})
@Serializable
internal data class StreamListMessagesRequest({/// The channel to subscribe to
String? channel, /// number of message to return
int? limit,})
@Serializable
data class StreamListMessagesResponse({/// The channel subscribed to
String? channel, /// Messages are chronological order
List<Message>? messages,})
@Serializable
internal data class StreamMessage({/// the channel name
String? channel, /// id of the message
String? id, /// the associated metadata
Map<String, String>? metadata, /// text of the message
String? text, /// time of message creation
String? timestamp,})
@Serializable
internal data class StreamSendMessageRequest({/// The channel to send to
String? channel, /// The message text to send
String? text,})
@Serializable
data class StreamSendMessageResponse()
