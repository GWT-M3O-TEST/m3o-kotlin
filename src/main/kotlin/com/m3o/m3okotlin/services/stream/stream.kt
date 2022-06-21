
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
}
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
    suspend fun listChannels(): StreamListChannelsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "ListChannels")) 
    }
}
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
    suspend fun listMessages(req: StreamListMessagesRequest): StreamListMessagesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "ListMessages")) {
          body = req
        }
    }
}
    suspend fun sendMessage(req: StreamSendMessageRequest){
      return ktorHttpClient.post(getUrl(SERVICE, "SendMessage")) {
        body = req
      }
    }
}
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
