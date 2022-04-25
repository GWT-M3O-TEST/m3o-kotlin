
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
internal data class NewsArticle({/// categories
List<String>? categories, /// article description
String? description, /// article id
String? id, /// image url
String? image_url, /// related keywords
String? keywords, /// the locale
String? locale, /// url of the article
String? url, /// the article language
String? language, /// time it was published
String? published_at, /// first 60 characters of article body
String? snippet, /// source of news
String? source, /// article title
String? title,})
@Serializable
internal data class NewsHeadlinesRequest({/// date published on in YYYY-MM-DD format
String? date, /// comma separated list of languages to retrieve in e.g en,es
String? language, /// comma separated list of countries to include e.g us,ca
String? locale,})
@Serializable
data class NewsHeadlinesResponse({List<Article>? articles,})
