
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "minecraft"

object MinecraftService {
    suspend fun ping(name: String): MinecraftPingResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Ping")) {
          body = MinecraftPingRequest(name)
        }
    }
}
@Serializable
internal data class MinecraftPingRequest()
@Serializable
data class MinecraftPingResponse()
@Serializable
internal data class MinecraftPlayerSample()
