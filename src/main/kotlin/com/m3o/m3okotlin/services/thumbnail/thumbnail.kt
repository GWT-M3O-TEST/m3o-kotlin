
package com.m3o.m3okotlin.services.thumbnail

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "thumbnail"

object ThumbnailService {
      suspend fun screenshot(req: ThumbnailScreenshotRequest): ThumbnailScreenshotResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Screenshot")) {
          body = req
        }
      }
}
@Serializable
data class ThumbnailScreenshotRequest(val width: Int, val height: Int, val url: String)
@Serializable
data class ThumbnailScreenshotResponse(val imageURL: String)
