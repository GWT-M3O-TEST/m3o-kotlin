
package com.m3o.m3okotlin.services.gifs

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "gifs"

object GifsService {
    suspend fun search(req: GifsSearchRequest): GifsSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = req
        }
    }
}
@Serializable
data class GifsGif(val embed_url: String, val id: String, val images: GifsImageFormats, val short_url: String, val title: String, val rating: String, val slug: String, val source: String, val url: String)
@Serializable
data class GifsImageFormat(val webp_size: Int, val webp_url: String, val width: Int, val height: Int, val mp4_size: Int, val mp4_url: String, val size: Int, val url: String)
@Serializable
data class GifsImageFormats(val downsized: GifsImageFormat, val fixed_height_downsampled: GifsImageFormat, val fixed_width_downsampled: GifsImageFormat, val looping: GifsImageFormat, val preview_gif: GifsImageFormat, val downsized_large: GifsImageFormat, val fixed_width_small: GifsImageFormat, val original_still: GifsImageFormat, val downsized_small: GifsImageFormat, val fixed_height: GifsImageFormat, val fixed_height_small: GifsImageFormat, val fixed_height_small_still: GifsImageFormat, val fixed_width_small_still: GifsImageFormat, val original: GifsImageFormat, val downsized_medium: GifsImageFormat, val downsized_still: GifsImageFormat, val fixed_height_still: GifsImageFormat, val fixed_width: GifsImageFormat, val fixed_width_still: GifsImageFormat, val preview: GifsImageFormat)
@Serializable
data class GifsPagination(val count: Int, val offset: Int, val total_count: Int)
@Serializable
data class GifsSearchRequest(val lang: String, val limit: Int, val offset: Int, val query: String, val rating: String)
@Serializable
data class GifsSearchResponse(val data: List<GifsGif>, val pagination: GifsPagination)
