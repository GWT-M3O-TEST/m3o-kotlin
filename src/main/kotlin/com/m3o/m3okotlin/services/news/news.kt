
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "news"

object NewsService {
    suspend fun headlines(name: String): NewsHeadlinesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Headlines")) {
          body = NewsHeadlinesRequest(name)
        }
    }
}
@Serializable
internal data class NewsArticle(val snippet: String, val source: String, val title: String, val description: String, val id: String, val image_url: String, val language: String, val locale: String, val url: String, val categories: List<NewsString>, val keywords: String, val published_at: String)
@Serializable
internal data class NewsHeadlinesRequest(val language: String, val locale: String, val date: String)
@Serializable
data class NewsHeadlinesResponse(val articles: List<NewsArticle>)
