
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
internal data class MinecraftPingRequest({/// address of the server
String? address,})
@Serializable
data class MinecraftPingResponse({/// Latency (ms) between us and the server (EU)
int? latency, /// Max players ever
int? max_players, /// Message of the day
String? motd, /// Number of players online
int? players, /// Protocol number of the server
int? protocol, /// List of connected players
List<PlayerSample>? sample, /// Version of the server
String? version, /// Favicon in base64
String? favicon,})
@Serializable
internal data class MinecraftPlayerSample({/// name of the player
String? name, /// unique id of player
String? uuid,})
