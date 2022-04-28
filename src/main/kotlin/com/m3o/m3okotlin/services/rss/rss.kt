
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "rss"

object RssService {
    suspend fun add(name: String): RssAddResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Add")) {
          body = RssAddRequest(name)
        }
    }
    suspend fun feed(name: String): RssFeedResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Feed")) {
          body = RssFeedRequest(name)
        }
    }
    suspend fun list(name: String): RssListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = RssListRequest(name)
        }
    }
    suspend fun remove(name: String): RssRemoveResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Remove")) {
          body = RssRemoveRequest(name)
        }
    }
}
@Serializable
internal data class RssAddRequest(val url: String, val category: String, val name: String)
@Serializable
data class RssAddResponse()
@Serializable
internal data class RssEntry(val date: String, val feed: String, val id: String, val link: String, val summary: String, val title: String, val content: String)
@Serializable
internal data class RssFeed(val category: String, val id: String, val name: String, val url: String)
@Serializable
internal data class RssFeedRequest(val offset: Long, val limit: Long, val name: String)
@Serializable
data class RssFeedResponse(val entries: List<RssEntry>)
@Serializable
internal data class RssListRequest()
@Serializable
data class RssListResponse(val feeds: List<RssFeed>)
@Serializable
internal data class RssRemoveRequest(val name: String)
@Serializable
data class RssRemoveResponse()
