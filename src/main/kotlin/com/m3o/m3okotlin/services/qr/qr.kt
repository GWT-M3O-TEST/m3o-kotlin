
package com.m3o.m3okotlin.services.qr

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "qr"

object QrService {
      suspend fun generate(req: QrGenerateRequest): QrGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
          body = req
        }
      }
}
@Serializable
data class QrGenerateRequest(val size: Long, val text: String)
@Serializable
data class QrGenerateResponse(val qr: String)
