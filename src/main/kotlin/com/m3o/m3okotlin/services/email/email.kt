
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
internal data class EmailParseRequest({/// The address to parse. Can be of the format "Joe Blogs <joe@example.com>" or "joe@example.com"
String? address,})
@Serializable
data class EmailParseResponse({/// the email address
String? address, /// associated name e.g Joe Blogs
String? name,})
@Serializable
internal data class EmailSendRequest({/// the display name of the sender
String? from, /// the html body
String? html_body, /// an optional reply to email address
String? reply_to, /// the email subject
String? subject, /// the text body
String? text_body, /// the email address of the recipient
String? to,})
@Serializable
data class EmailSendResponse()
@Serializable
internal data class EmailValidateRequest({String? address,})
@Serializable
data class EmailValidateResponse({bool? is_valid,})
