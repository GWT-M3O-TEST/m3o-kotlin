
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
}
    suspend fun publish(req: EventPublishRequest){
      return ktorHttpClient.post(getUrl(SERVICE, "Publish")) {
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
    suspend fun read(req: EventReadRequest): EventReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = req
        }
    }
}
