
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
data class NewsArticle(val description: String, val id: String, val keywords: String, val language: String, val snippet: String, val source: String, val categories: List<String>, val image_url: String, val locale: String, val published_at: String, val title: String, val url: String)
@Serializable
data class NewsHeadlinesRequest(val locale: String, val date: String, val language: String)
@Serializable
data class NewsHeadlinesResponse(val articles: List<NewsArticle>)
