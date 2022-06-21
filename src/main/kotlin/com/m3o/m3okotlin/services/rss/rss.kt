
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
}
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
    suspend fun feed(req: RssFeedRequest): RssFeedResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Feed")) {
          body = req
        }
    }
}
    suspend fun list(): RssListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) 
    }
}
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
    suspend fun remove(req: RssRemoveRequest){
      return ktorHttpClient.post(getUrl(SERVICE, "Remove")) {
        body = req
      }
    }
}
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
