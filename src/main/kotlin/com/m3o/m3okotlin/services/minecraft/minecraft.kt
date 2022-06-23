
package com.m3o.m3okotlin.services.minecraft

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "minecraft"

object MinecraftService {
      suspend fun ping(req: MinecraftPingRequest): MinecraftPingResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Ping")) {
          body = req
        }
      }
}
@Serializable
data class MinecraftPingRequest(val address: String)
@Serializable
data class MinecraftPingResponse(val favicon: String, val latency: Int, val max_players: Int, val motd: String, val players: Int, val protocol: Int, val sample: List<MinecraftPlayerSample>, val version: String)
@Serializable
data class MinecraftPlayerSample(val name: String, val uuid: String)
