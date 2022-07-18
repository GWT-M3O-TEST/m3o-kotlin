
package com.m3o.m3okotlin.services.rss

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "rss"

object RssServ {
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
data class RssAddRequest(val category: String? = null, val name: String? = null, val url: String? = null)
@Serializable
data class RssEntry(val date: String? = null, val feed: String? = null, val id: String? = null, val link: String? = null, val summary: String? = null, val title: String? = null, val content: String? = null)
@Serializable
data class RssFeed(val category: String? = null, val id: String? = null, val name: String? = null, val url: String? = null)
@Serializable
data class RssFeedRequest(val limit: Long? = null, val name: String? = null, val offset: Long? = null)
@Serializable
data class RssFeedResponse(val entries: List<RssEntry>? = null)
@Serializable
data class RssListResponse(val feeds: List<RssFeed>? = null)
@Serializable
data class RssRemoveRequest(val name: String? = null)
