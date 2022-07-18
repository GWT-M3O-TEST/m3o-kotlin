
package com.m3o.m3okotlin.services.joke

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "joke"

object JokeServ {
      suspend fun random(req: JokeRandomRequest): JokeRandomResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Random")) {
          body = req
        }
      }
}
@Serializable
data class JokeJokeInfo(val category: String? = null, val id: String? = null, val source: String? = null, val title: String? = null, val body: String? = null)
@Serializable
data class JokeRandomRequest(val count: Int? = null)
@Serializable
data class JokeRandomResponse(val jokes: List<JokeJokeInfo>? = null)
