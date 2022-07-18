
package com.m3o.m3okotlin.services.stream

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "stream"

object StreamServ {
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
data class StreamChannel(val description: String? = null, val last_active: String? = null, val name: String? = null)
@Serializable
data class StreamCreateChannelRequest(val description: String? = null, val name: String? = null)
@Serializable
data class StreamListChannelsResponse(val channels: List<StreamChannel>? = null)
@Serializable
data class StreamListMessagesRequest(val channel: String? = null, val limit: Int? = null)
@Serializable
data class StreamListMessagesResponse(val channel: String? = null, val messages: List<StreamMessage>? = null)
@Serializable
data class StreamMessage(val id: String? = null, val metadata: Map<String, String>? = null, val text: String? = null, val timestamp: String? = null, val channel: String? = null)
@Serializable
data class StreamSendMessageRequest(val channel: String? = null, val text: String? = null)
