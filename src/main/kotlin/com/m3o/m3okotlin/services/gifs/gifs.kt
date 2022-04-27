
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
internal data class GifsGif(val url: String, val embed_url: String, val id: String, val rating: String, val short_url: String, val images: GifsImageFormats, val slug: String, val source: String, val title: String)
@Serializable
internal data class GifsImageFormat(val webp_url: String, val width: Int, val height: Int, val mp4_size: Int, val mp4_url: String, val size: Int, val url: String, val webp_size: Int)
@Serializable
internal data class GifsImageFormats(val fixed_height_still: GifsImageFormat, val fixed_width: GifsImageFormat, val fixed_width_downsampled: GifsImageFormat, val preview: GifsImageFormat, val preview_gif: GifsImageFormat, val downsized: GifsImageFormat, val downsized_large: GifsImageFormat, val downsized_medium: GifsImageFormat, val fixed_height: GifsImageFormat, val fixed_width_small: GifsImageFormat, val fixed_width_small_still: GifsImageFormat, val downsized_still: GifsImageFormat, val fixed_height_downsampled: GifsImageFormat, val fixed_height_small: GifsImageFormat, val fixed_height_small_still: GifsImageFormat, val fixed_width_still: GifsImageFormat, val original_still: GifsImageFormat, val downsized_small: GifsImageFormat, val looping: GifsImageFormat, val original: GifsImageFormat)
@Serializable
internal data class GifsPagination(val count: Int, val offset: Int, val total_count: Int)
@Serializable
internal data class GifsSearchRequest(val rating: String, val lang: String, val limit: Int, val offset: Int, val query: String)
@Serializable
data class GifsSearchResponse(val data: List<GifsGif>, val pagination: GifsPagination)
