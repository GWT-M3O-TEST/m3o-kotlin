
package com.m3o.m3okotlin.services.avatar

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "avatar"

object AvatarServ {
      suspend fun generate(req: AvatarGenerateRequest): AvatarGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
          body = req
        }
      }
}
@Serializable
data class AvatarGenerateRequest(val gender: String? = null, val upload: Boolean? = null, val username: String? = null, val format: String? = null)
@Serializable
data class AvatarGenerateResponse(val base64: String? = null, val url: String? = null)
