
package com.m3o.m3okotlin.services.minecraft

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "minecraft"

object MinecraftServ {
      suspend fun ping(req: MinecraftPingRequest): MinecraftPingResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Ping")) {
          body = req
        }
      }
}
@Serializable
data class MinecraftPingRequest(val address: String? = null)
@Serializable
data class MinecraftPingResponse(val max_players: Int? = null, val motd: String? = null, val players: Int? = null, val protocol: Int? = null, val sample: List<MinecraftPlayerSample>? = null, val version: String? = null, val favicon: String? = null, val latency: Int? = null)
@Serializable
data class MinecraftPlayerSample(val uuid: String? = null, val name: String? = null)
