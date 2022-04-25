
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "google"

object GoogleService {
    suspend fun search(name: String): GoogleSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = GoogleSearchRequest(name)
        }
    }
}
@Serializable
internal data class GoogleSearchRequest({/// Query to search for
String? query,})
@Serializable
data class GoogleSearchResponse({/// List of results for the query
List<SearchResult>? results,})
@Serializable
internal data class GoogleSearchResult({/// abridged version of this search result’s URL, e.g. www.exampe.com
String? display_url, /// id of the result
String? id, /// kind of result; "search"
String? kind, /// the result snippet
String? snippet, /// title of the result
String? title, /// the full url for the result
String? url,})
