
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
internal data class GifsGif({/// The title for this GIF
String? title, /// URL used for embedding the GIF
String? embed_url, /// The ID of the GIF
String? id, /// The different formats available for this GIF
ImageFormats? images, /// The slug used in the GIF's URL
String? slug, /// The page on which this GIF was found
String? source, /// The content rating for the GIF
String? rating, /// A short URL for this GIF
String? short_url, /// The URL for this GIF
String? url,})
@Serializable
internal data class GifsImageFormat({/// size of the webp version
int? webp_size, /// URL to a webp version of the gif
String? webp_url, /// width
int? width, /// height
int? height, /// size of the MP4 version
int? mp4_size, /// URL to an MP4 version of the gif
String? mp4_url, /// size in bytes
int? size, /// URL of the gif
String? url,})
@Serializable
internal data class GifsImageFormats({/// Version of the GIF with fixed height of 100 pixels. Good for mobile keyboards
ImageFormat? fixed_height_small, /// Static image of the GIF with fixed height of 200 pixels
ImageFormat? fixed_height_still, /// Version of the GIF with fixed width of 200 pixels and number of frames reduced to 6
ImageFormat? fixed_width_downsampled, /// Version of the GIF with fixed width of 100 pixels. Good for mobile keyboards
ImageFormat? fixed_width_small, /// Static image of the GIF with fixed width of 200 pixels
ImageFormat? fixed_width_still, /// mp4 version of the GIF <50kb displaying first 1-2 secs
ImageFormat? preview, /// Version of the GIF <50kb displaying first 1-2 secs
ImageFormat? preview_gif, /// A downsized version of the GIF < 5MB
ImageFormat? downsized_medium, /// A downsized version of the GIF < 200kb
ImageFormat? downsized_small, /// Version of the GIF with fixed height of 200 pixels and number of frames reduced to 6
ImageFormat? fixed_height_downsampled, /// 15 second version of the GIF looping
ImageFormat? looping, /// The original GIF. Good for desktop use
ImageFormat? original, /// A downsized version of the GIF < 8MB
ImageFormat? downsized_large, /// Static image of the downsized version of the GIF
ImageFormat? downsized_still, /// Version of the GIF with fixed height of 200 pixels. Good for mobile use
ImageFormat? fixed_height, /// Static image of the GIF with fixed height of 100 pixels
ImageFormat? fixed_height_small_still, /// Version of the GIF with fixed width of 200 pixels. Good for mobile use
ImageFormat? fixed_width, /// Static image of the GIF with fixed width of 100 pixels
ImageFormat? fixed_width_small_still, /// Static image of the original version of the GIF
ImageFormat? original_still, /// A downsized version of the GIF < 2MB
ImageFormat? downsized,})
@Serializable
internal data class GifsPagination({/// total number returned in this response
int? count, /// position in pagination
int? offset, /// total number of results available
int? total_count,})
@Serializable
internal data class GifsSearchRequest({/// Apply age related content filter. "g", "pg", "pg-13", or "r". Defaults to "g"
String? rating, /// ISO 2 letter language code for regional content
String? lang, /// Max number of gifs to return. Defaults to 25
int? limit, /// The start position of results (used with pagination)
int? offset, /// The search term
String? query,})
@Serializable
data class GifsSearchResponse({/// information on pagination
Pagination? pagination, /// list of results
List<Gif>? data,})
