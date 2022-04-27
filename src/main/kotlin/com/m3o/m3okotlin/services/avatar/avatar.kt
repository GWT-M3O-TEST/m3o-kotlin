
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "avatar"

object AvatarService {
    suspend fun generate(name: String): AvatarGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
          body = AvatarGenerateRequest(name)
        }
    }
}
@Serializable
internal data class AvatarGenerateRequest(val format: String, val gender: String, val upload: Boolean, val username: String)
@Serializable
data class AvatarGenerateResponse(val base64: String, val url: String)
