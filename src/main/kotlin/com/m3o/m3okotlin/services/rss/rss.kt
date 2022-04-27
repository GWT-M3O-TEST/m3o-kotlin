
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
internal data class RssAddRequest()
@Serializable
data class RssAddResponse()
@Serializable
internal data class RssEntry()
@Serializable
internal data class RssFeed()
@Serializable
internal data class RssFeedRequest()
@Serializable
data class RssFeedResponse()
@Serializable
internal data class RssListRequest()
@Serializable
data class RssListResponse()
@Serializable
internal data class RssRemoveRequest()
@Serializable
data class RssRemoveResponse()
