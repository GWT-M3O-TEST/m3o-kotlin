
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "sms"

object SmsService {
    suspend fun send(name: String): SmsSendResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Send")) {
          body = SmsSendRequest(name)
        }
    }
}
@Serializable
internal data class SmsSendRequest()
@Serializable
data class SmsSendResponse()
