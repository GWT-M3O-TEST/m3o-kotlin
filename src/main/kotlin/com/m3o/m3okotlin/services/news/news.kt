
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
    suspend fun headlines(req: NewsHeadlinesRequest): NewsHeadlinesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Headlines")) {
          body = req
        }
    }
}
@Serializable
internal data class NewsArticle(val language: String, val locale: String, val published_at: String, val url: String, val categories: List<NewsString>, val description: String, val image_url: String, val source: String, val title: String, val id: String, val keywords: String, val snippet: String)
@Serializable
internal data class NewsHeadlinesRequest(val date: String, val language: String, val locale: String)
@Serializable
data class NewsHeadlinesResponse(val articles: List<NewsArticle>)
