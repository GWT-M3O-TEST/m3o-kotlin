
package com.m3o.m3okotlin.services.google

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "google"

object GoogleServ {
      suspend fun search(req: GoogleSearchRequest): GoogleSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = req
        }
      }
}
@Serializable
data class GoogleSearchRequest(val query: String? = null)
@Serializable
data class GoogleSearchResponse(val results: List<GoogleSearchResult>? = null)
@Serializable
data class GoogleSearchResult(val kind: String? = null, val snippet: String? = null, val title: String? = null, val url: String? = null, val display_url: String? = null, val id: String? = null)
