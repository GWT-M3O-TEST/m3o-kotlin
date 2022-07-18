
package com.m3o.m3okotlin.services.password

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "password"

object PasswordServ {
      suspend fun generate(req: PasswordGenerateRequest): PasswordGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
          body = req
        }
      }
}
@Serializable
data class PasswordGenerateRequest(val numbers: Boolean? = null, val special: Boolean? = null, val uppercase: Boolean? = null, val length: Int? = null, val lowercase: Boolean? = null)
@Serializable
data class PasswordGenerateResponse(val password: String? = null)
