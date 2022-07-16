
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

object NewsService {
      suspend fun headlines(req: NewsHeadlinesRequest): NewsHeadlinesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Headlines")) {
          body = req
        }
      }
}
@Serializable
data class NewsArticle(val snippet: String, val title: String, val categories: List<String>, val language: String, val locale: String, val keywords: String, val published_at: String, val source: String, val url: String, val description: String, val id: String, val image_url: String)
@Serializable
data class NewsHeadlinesRequest(val language: String, val locale: String, val date: String)
@Serializable
data class NewsHeadlinesResponse(val articles: List<NewsArticle>)
