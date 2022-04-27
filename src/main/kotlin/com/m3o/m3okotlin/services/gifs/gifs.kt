
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "gifs"

object GifsService {
    suspend fun search(name: String): GifsSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = GifsSearchRequest(name)
        }
    }
}
@Serializable
internal data class GifsGif()
@Serializable
internal data class GifsImageFormat()
@Serializable
internal data class GifsImageFormats()
@Serializable
internal data class GifsPagination()
@Serializable
internal data class GifsSearchRequest()
@Serializable
data class GifsSearchResponse()
