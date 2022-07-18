
package com.m3o.m3okotlin.services.sms

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "sms"

object SmsServ {
      suspend fun send(req: SmsSendRequest): SmsSendResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Send")) {
          body = req
        }
      }
}
@Serializable
data class SmsSendRequest(val from: String? = null, val message: String? = null, val to: String? = null)
@Serializable
data class SmsSendResponse(val info: String? = null, val status: String? = null)
