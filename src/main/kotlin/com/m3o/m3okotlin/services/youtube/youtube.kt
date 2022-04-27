
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "youtube"

object YoutubeService {
    suspend fun embed(name: String): YoutubeEmbedResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Embed")) {
          body = YoutubeEmbedRequest(name)
        }
    }
    suspend fun search(name: String): YoutubeSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = YoutubeSearchRequest(name)
        }
    }
}
@Serializable
internal data class YoutubeEmbedRequest()
@Serializable
data class YoutubeEmbedResponse()
@Serializable
internal data class YoutubeSearchRequest()
@Serializable
data class YoutubeSearchResponse()
@Serializable
internal data class YoutubeSearchResult()
