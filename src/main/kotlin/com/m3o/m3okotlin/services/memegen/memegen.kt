
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "memegen"

object MemegenService {
    suspend fun generate(name: String): MemegenGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
          body = MemegenGenerateRequest(name)
        }
    }
    suspend fun templates(name: String): MemegenTemplatesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Templates")) {
          body = MemegenTemplatesRequest(name)
        }
    }
}
@Serializable
internal data class MemegenBox()
@Serializable
internal data class MemegenGenerateRequest()
@Serializable
data class MemegenGenerateResponse()
@Serializable
internal data class MemegenTemplate()
@Serializable
internal data class MemegenTemplatesRequest()
@Serializable
data class MemegenTemplatesResponse()
