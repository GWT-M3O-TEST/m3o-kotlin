
package com.m3o.m3okotlin.services.gifs

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "gifs"

object GifsServ {
      suspend fun search(req: GifsSearchRequest): GifsSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = req
        }
      }
}
@Serializable
data class GifsGif(val id: String? = null, val short_url: String? = null, val source: String? = null, val title: String? = null, val embed_url: String? = null, val images: GifsImageFormats? = null, val rating: String? = null, val slug: String? = null, val url: String? = null)
@Serializable
data class GifsImageFormat(val mp4_url: String? = null, val size: Int? = null, val url: String? = null, val webp_size: Int? = null, val webp_url: String? = null, val width: Int? = null, val height: Int? = null, val mp4_size: Int? = null)
@Serializable
data class GifsImageFormats(val downsized_still: GifsImageFormat? = null, val fixed_height_small: GifsImageFormat? = null, val fixed_height_small_still: GifsImageFormat? = null, val preview: GifsImageFormat? = null, val downsized_large: GifsImageFormat? = null, val downsized_small: GifsImageFormat? = null, val fixed_height: GifsImageFormat? = null, val fixed_height_downsampled: GifsImageFormat? = null, val fixed_width_still: GifsImageFormat? = null, val original: GifsImageFormat? = null, val fixed_height_still: GifsImageFormat? = null, val fixed_width: GifsImageFormat? = null, val fixed_width_downsampled: GifsImageFormat? = null, val fixed_width_small: GifsImageFormat? = null, val fixed_width_small_still: GifsImageFormat? = null, val preview_gif: GifsImageFormat? = null, val downsized: GifsImageFormat? = null, val downsized_medium: GifsImageFormat? = null, val looping: GifsImageFormat? = null, val original_still: GifsImageFormat? = null)
@Serializable
data class GifsPagination(val offset: Int? = null, val total_count: Int? = null, val count: Int? = null)
@Serializable
data class GifsSearchRequest(val lang: String? = null, val limit: Int? = null, val offset: Int? = null, val query: String? = null, val rating: String? = null)
@Serializable
data class GifsSearchResponse(val data: List<GifsGif>? = null, val pagination: GifsPagination? = null)
