
package com.m3o.m3okotlin.services.email

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "email"

object EmailServ {
      suspend fun parse(req: EmailParseRequest): EmailParseResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Parse")) {
          body = req
        }
      }
      suspend fun send(req: EmailSendRequest){
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
data class EmailParseRequest(val address: String? = null)
@Serializable
data class EmailParseResponse(val address: String? = null, val name: String? = null)
@Serializable
data class EmailSendRequest(val html_body: String? = null, val reply_to: String? = null, val subject: String? = null, val text_body: String? = null, val to: String? = null, val from: String? = null)
@Serializable
data class EmailValidateRequest(val address: String? = null)
@Serializable
data class EmailValidateResponse(val is_valid: Boolean? = null)
