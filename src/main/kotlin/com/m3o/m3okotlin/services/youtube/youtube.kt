
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
internal data class YoutubeEmbedRequest({/// provide the youtube url
String? url,})
@Serializable
data class YoutubeEmbedResponse({/// the embeddable link
String? embed_url, /// the script code
String? html_script, /// the full url
String? long_url, /// the short url
String? short_url,})
@Serializable
internal data class YoutubeSearchRequest({/// Query to search for
String? query,})
@Serializable
data class YoutubeSearchResponse({/// List of results for the query
List<SearchResult>? results,})
@Serializable
internal data class YoutubeSearchResult({/// title of the result
String? title, /// the channel title
String? channel_title, /// kind of result: "video", "channel", "playlist"
String? kind, /// published at time
String? published_at, /// id of the result
String? id, /// the associated url
String? url, /// if live broadcast then indicates activity:
/// none, upcoming, live, completed
String? broadcasting, /// the channel id
String? channel_id, /// the result description
String? description,})
