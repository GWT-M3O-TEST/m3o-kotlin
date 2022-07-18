
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

object YoutubeServ {
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
data class YoutubeEmbedRequest(val url: String? = null)
@Serializable
data class YoutubeEmbedResponse(val embed_url: String? = null, val html_script: String? = null, val long_url: String? = null, val short_url: String? = null)
@Serializable
data class YoutubeSearchRequest(val query: String? = null)
@Serializable
data class YoutubeSearchResponse(val results: List<YoutubeSearchResult>? = null)
@Serializable
data class YoutubeSearchResult(val title: String? = null, val url: String? = null, val channel_id: String? = null, val channel_title: String? = null, val description: String? = null, val id: String? = null, val kind: String? = null, val published_at: String? = null, val broadcasting: String? = null)
