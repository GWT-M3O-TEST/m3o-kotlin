
package com.m3o.m3okotlin.services.news

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "news"

object NewsService {
    suspend fun headlines(req: NewsHeadlinesRequest): NewsHeadlinesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Headlines")) {
          body = req
        }
    }
}
@Serializable
data class NewsArticle(val title: String, val image_url: String, val keywords: String, val published_at: String, val source: String, val locale: String, val snippet: String, val url: String, val categories: List<NewsString>, val description: String, val id: String, val language: String)
@Serializable
data class NewsHeadlinesRequest(val locale: String, val date: String, val language: String)
@Serializable
data class NewsHeadlinesResponse(val articles: List<NewsArticle>)
