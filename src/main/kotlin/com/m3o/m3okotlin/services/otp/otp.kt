
package com.m3o.m3okotlin.services.otp

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "otp"

object OtpServ {
      suspend fun generate(req: OtpGenerateRequest): OtpGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
          body = req
        }
      }
      suspend fun validate(req: OtpValidateRequest): OtpValidateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Validate")) {
          body = req
        }
      }
}
@Serializable
data class OtpGenerateRequest(val expiry: Long? = null, val id: String? = null, val size: Long? = null)
@Serializable
data class OtpGenerateResponse(val code: String? = null)
@Serializable
data class OtpValidateRequest(val code: String? = null, val id: String? = null)
@Serializable
data class OtpValidateResponse(val success: Boolean? = null)
