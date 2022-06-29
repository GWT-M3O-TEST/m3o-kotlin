
package com.m3o.m3okotlin.services.stream

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "stream"

object StreamService {
      suspend fun createChannel(req: StreamCreateChannelRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "CreateChannel")) {
          body = req
        }
      }
      suspend fun listChannels(): StreamListChannelsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "ListChannels")) 
      }
      suspend fun listMessages(req: StreamListMessagesRequest): StreamListMessagesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "ListMessages")) {
          body = req
        }
      }
      suspend fun sendMessage(req: StreamSendMessageRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "SendMessage")) {
          body = req
        }
      }
}
@Serializable
data class StreamChannel(val description: String, val last_active: String, val name: String)
@Serializable
data class StreamCreateChannelRequest(val description: String, val name: String)
@Serializable
data class StreamListChannelsResponse(val channels: List<StreamChannel>)
@Serializable
data class StreamListMessagesRequest(val channel: String, val limit: Int)
@Serializable
data class StreamListMessagesResponse(val channel: String, val messages: List<StreamMessage>)
@Serializable
data class StreamMessage(val text: String, val timestamp: String, val channel: String, val id: String, val metadata: Map<String, String>)
@Serializable
data class StreamSendMessageRequest(val channel: String, val text: String)
