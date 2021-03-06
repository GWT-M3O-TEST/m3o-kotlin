
package com.m3o.m3okotlin.services.mq

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient
import com.m3o.m3okotlin.WebSocket

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "mq"

object MqServ {
      suspend fun publish(req: MqPublishRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "Publish")) {
          body = req
        }
      }
      fun subscribe(req: MqSubscribeRequest, action: (Exception?, MqSubscribeResponse?) -> Unit) {
          val url = getUrl(SERVICE, "Subscribe", true)
          WebSocket(url, Json.encodeToString(req)) { e, response ->
              action(e, if (response != null) Json.decodeFromString(response) else null)
          }.connect()
      }
}
@Serializable
data class MqPublishRequest(val message: JsonObject? = null, val topic: String? = null)
@Serializable
data class MqSubscribeRequest(val topic: String? = null)
@Serializable
data class MqSubscribeResponse(val message: JsonObject? = null, val topic: String? = null)
