
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "joke"

object JokeService {
    suspend fun random(name: String): JokeRandomResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Random")) {
          body = JokeRandomRequest(name)
        }
    }
}
@Serializable
internal data class JokeJokeInfo(val source: String, val title: String, val body: String, val category: String, val id: String)
@Serializable
internal data class JokeRandomRequest(val count: Int)
@Serializable
data class JokeRandomResponse(val jokes: List<JokeJokeInfo>)
