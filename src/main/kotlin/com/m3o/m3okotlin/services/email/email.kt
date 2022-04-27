
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "email"

object EmailService {
    suspend fun parse(name: String): EmailParseResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Parse")) {
          body = EmailParseRequest(name)
        }
    }
    suspend fun send(name: String): EmailSendResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Send")) {
          body = EmailSendRequest(name)
        }
    }
    suspend fun validate(name: String): EmailValidateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Validate")) {
          body = EmailValidateRequest(name)
        }
    }
}
@Serializable
internal data class EmailParseRequest()
@Serializable
data class EmailParseResponse()
@Serializable
internal data class EmailSendRequest()
@Serializable
data class EmailSendResponse()
@Serializable
internal data class EmailValidateRequest()
@Serializable
data class EmailValidateResponse()
