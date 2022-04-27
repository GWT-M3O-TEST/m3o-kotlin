
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "carbon"

object CarbonService {
    suspend fun offset(name: String): CarbonOffsetResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Offset")) {
          body = CarbonOffsetRequest(name)
        }
    }
}
@Serializable
internal data class CarbonOffsetRequest()
@Serializable
data class CarbonOffsetResponse()
@Serializable
internal data class CarbonProject()
