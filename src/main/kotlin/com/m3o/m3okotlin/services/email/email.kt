
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
internal data class EmailParseRequest(val address: String)
@Serializable
data class EmailParseResponse(val address: String, val name: String)
@Serializable
internal data class EmailSendRequest(val from: String, val html_body: String, val reply_to: String, val subject: String, val text_body: String, val to: String)
@Serializable
data class EmailSendResponse()
@Serializable
internal data class EmailValidateRequest(val address: String)
@Serializable
data class EmailValidateResponse(val is_valid: Boolean)
