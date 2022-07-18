
package com.m3o.m3okotlin.services.news

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "news"

object NewsServ {
      suspend fun headlines(req: NewsHeadlinesRequest): NewsHeadlinesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Headlines")) {
          body = req
        }
      }
}
@Serializable
data class NewsArticle(val id: String? = null, val image_url: String? = null, val language: String? = null, val locale: String? = null, val source: String? = null, val title: String? = null, val categories: List<String>? = null, val description: String? = null, val keywords: String? = null, val published_at: String? = null, val snippet: String? = null, val url: String? = null)
@Serializable
data class NewsHeadlinesRequest(val locale: String? = null, val date: String? = null, val language: String? = null)
@Serializable
data class NewsHeadlinesResponse(val articles: List<NewsArticle>? = null)
