
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
    suspend fun add(req: RssAddRequest): RssAddResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Add")) {
          body = req
        }
    }
    suspend fun feed(req: RssFeedRequest): RssFeedResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Feed")) {
          body = req
        }
    }
    suspend fun list(req: RssListRequest): RssListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = req
        }
    }
    suspend fun remove(req: RssRemoveRequest): RssRemoveResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Remove")) {
          body = req
        }
    }
}
@Serializable
internal data class RssAddRequest(val category: String, val name: String, val url: String)
@Serializable
data class RssAddResponse()
@Serializable
internal data class RssEntry(val title: String, val content: String, val date: String, val feed: String, val id: String, val link: String, val summary: String)
@Serializable
internal data class RssFeed(val id: String, val name: String, val url: String, val category: String)
@Serializable
internal data class RssFeedRequest(val name: String, val offset: Long, val limit: Long)
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
