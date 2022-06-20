
package com.m3o.m3okotlin.services.sms

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "sms"

object SmsService {
    suspend fun send(req: SmsSendRequest): SmsSendResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Send")) {
          body = req
        }
    }
}
@Serializable
data class SmsSendRequest(val to: String, val from: String, val message: String)
@Serializable
data class SmsSendResponse(val info: String, val status: String)
