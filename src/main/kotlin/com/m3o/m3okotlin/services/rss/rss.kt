
package com.m3o.m3okotlin.services.rss

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "rss"

object RssService {
      suspend fun add(req: RssAddRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "Add")) {
          body = req
        }
      }
      suspend fun feed(req: RssFeedRequest): RssFeedResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Feed")) {
          body = req
        }
      }
      suspend fun list(): RssListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) 
      }
      suspend fun remove(req: RssRemoveRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "Remove")) {
          body = req
        }
      }
}
@Serializable
data class RssAddRequest(val category: String, val name: String, val url: String)
@Serializable
data class RssEntry(val content: String, val date: String, val feed: String, val id: String, val link: String, val summary: String, val title: String)
@Serializable
data class RssFeed(val category: String, val id: String, val name: String, val url: String)
@Serializable
data class RssFeedRequest(val limit: Long, val name: String, val offset: Long)
@Serializable
data class RssFeedResponse(val entries: List<RssEntry>)
@Serializable
data class RssListResponse(val feeds: List<RssFeed>)
@Serializable
data class RssRemoveRequest(val name: String)
