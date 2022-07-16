
package com.m3o.m3okotlin.services.youtube

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "youtube"

object YoutubeService {
      suspend fun embed(req: YoutubeEmbedRequest): YoutubeEmbedResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Embed")) {
          body = req
        }
      }
      suspend fun search(req: YoutubeSearchRequest): YoutubeSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = req
        }
      }
}
@Serializable
data class YoutubeEmbedRequest(val url: String)
@Serializable
data class YoutubeEmbedResponse(val embed_url: String, val html_script: String, val long_url: String, val short_url: String)
@Serializable
data class YoutubeSearchRequest(val query: String)
@Serializable
data class YoutubeSearchResponse(val results: List<YoutubeSearchResult>)
@Serializable
data class YoutubeSearchResult(val broadcasting: String, val channel_title: String, val kind: String, val url: String, val channel_id: String, val description: String, val id: String, val published_at: String, val title: String)
