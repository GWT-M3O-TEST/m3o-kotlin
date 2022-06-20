
package com.m3o.m3okotlin.services.avatar

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "avatar"

object AvatarService {
    suspend fun generate(req: AvatarGenerateRequest): AvatarGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
          body = req
        }
    }
}
@Serializable
data class AvatarGenerateRequest(val username: String, val format: String, val gender: String, val upload: Boolean)
@Serializable
data class AvatarGenerateResponse(val base64: String, val url: String)
