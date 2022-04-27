
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "qr"

object QrService {
    suspend fun generate(name: String): QrGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
          body = QrGenerateRequest(name)
        }
    }
}
@Serializable
internal data class QrGenerateRequest()
@Serializable
data class QrGenerateResponse()
