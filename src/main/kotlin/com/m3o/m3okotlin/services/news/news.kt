
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
internal data class NewsArticle(val language: String, val title: String, val image_url: String, val description: String, val id: String, val keywords: String, val locale: String, val published_at: String, val snippet: String, val source: String, val categories: List<NewsString>, val url: String)
@Serializable
internal data class NewsHeadlinesRequest(val date: String, val language: String, val locale: String)
@Serializable
data class NewsHeadlinesResponse(val articles: List<NewsArticle>)
