
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
internal data class JokeJokeInfo({String? category, String? id, String? source, String? title, String? body,})
@Serializable
internal data class JokeRandomRequest({/// the count of random jokes want, maximum: 10
int? count,})
@Serializable
data class JokeRandomResponse({List<JokeInfo>? jokes,})
