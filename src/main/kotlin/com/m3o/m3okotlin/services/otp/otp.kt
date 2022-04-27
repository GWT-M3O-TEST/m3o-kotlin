
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "otp"

object OtpService {
    suspend fun generate(name: String): OtpGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
          body = OtpGenerateRequest(name)
        }
    }
    suspend fun validate(name: String): OtpValidateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Validate")) {
          body = OtpValidateRequest(name)
        }
    }
}
@Serializable
internal data class OtpGenerateRequest()
@Serializable
data class OtpGenerateResponse()
@Serializable
internal data class OtpValidateRequest()
@Serializable
data class OtpValidateResponse()
