
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
internal data class YoutubeEmbedRequest(val url: String)
@Serializable
data class YoutubeEmbedResponse(val embed_url: String, val html_script: String, val long_url: String, val short_url: String)
@Serializable
internal data class YoutubeSearchRequest(val query: String)
@Serializable
data class YoutubeSearchResponse(val results: List<YoutubeSearchResult>)
@Serializable
internal data class YoutubeSearchResult(val broadcasting: String, val channel_title: String, val description: String, val kind: String, val url: String, val channel_id: String, val id: String, val published_at: String, val title: String)
