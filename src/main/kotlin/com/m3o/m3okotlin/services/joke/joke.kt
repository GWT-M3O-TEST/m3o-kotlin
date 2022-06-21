
package com.m3o.m3okotlin.services.joke

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "joke"

object JokeService {
    suspend fun random(req: JokeRandomRequest): JokeRandomResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Random")) {
          body = req
        }
    }
}
