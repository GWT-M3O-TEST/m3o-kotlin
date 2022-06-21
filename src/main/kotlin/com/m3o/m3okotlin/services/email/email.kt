
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
}
    suspend fun send(req: EmailSendRequest){
      return ktorHttpClient.post(getUrl(SERVICE, "Send")) {
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
    suspend fun validate(req: EmailValidateRequest): EmailValidateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Validate")) {
          body = req
        }
    }
}
