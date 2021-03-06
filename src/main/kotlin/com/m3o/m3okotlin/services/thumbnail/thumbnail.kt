
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

object ThumbnailServ {
      suspend fun screenshot(req: ThumbnailScreenshotRequest): ThumbnailScreenshotResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Screenshot")) {
          body = req
        }
      }
}
@Serializable
data class ThumbnailScreenshotRequest(val height: Int? = null, val url: String? = null, val width: Int? = null)
@Serializable
data class ThumbnailScreenshotResponse(val imageURL: String? = null)
