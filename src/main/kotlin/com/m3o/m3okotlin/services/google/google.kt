
package com.m3o.m3okotlin.services.google

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "google"

object GoogleService {
      suspend fun search(req: GoogleSearchRequest): GoogleSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = req
        }
      }
}
@Serializable
data class GoogleSearchRequest(val query: String)
@Serializable
data class GoogleSearchResponse(val results: List<GoogleSearchResult>)
@Serializable
data class GoogleSearchResult(val display_url: String, val id: String, val kind: String, val snippet: String, val title: String, val url: String)
