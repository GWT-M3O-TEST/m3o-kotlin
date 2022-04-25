
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "thumbnail"

object ThumbnailService {
    suspend fun screenshot(name: String): ThumbnailScreenshotResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Screenshot")) {
          body = ThumbnailScreenshotRequest(name)
        }
    }
}
@Serializable
internal data class ThumbnailScreenshotRequest({String? url, /// width of the browser window. optional
int? width, /// height of the browser window, optional
int? height,})
@Serializable
data class ThumbnailScreenshotResponse({String? imageURL,})
