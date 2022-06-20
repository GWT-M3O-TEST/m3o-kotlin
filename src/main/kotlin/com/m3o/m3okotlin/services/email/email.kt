
package com.m3o.m3okotlin.services.email

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "email"

object EmailService {
    suspend fun parse(req: EmailParseRequest): EmailParseResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Parse")) {
          body = req
        }
    }
    suspend fun send(req: EmailSendRequest): EmailSendResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Send")) {
          body = req
        }
    }
    suspend fun validate(req: EmailValidateRequest): EmailValidateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Validate")) {
          body = req
        }
    }
}
@Serializable
data class EmailParseRequest(val address: String)
@Serializable
data class EmailParseResponse(val address: String, val name: String)
@Serializable
data class EmailSendRequest(val to: String, val from: String, val html_body: String, val reply_to: String, val subject: String, val text_body: String)
@Serializable
data class EmailSendResponse()
@Serializable
data class EmailValidateRequest(val address: String)
@Serializable
data class EmailValidateResponse(val is_valid: Boolean)
