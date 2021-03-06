
package com.m3o.m3okotlin.services.movie

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "movie"

object MovieServ {
      suspend fun search(req: MovieSearchRequest): MovieSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = req
        }
      }
}
@Serializable
data class MovieMovieInfo(val video: Boolean? = null, val genre_ids: List<Int>? = null, val original_language: String? = null, val original_title: String? = null, val overview: String? = null, val poster_path: String? = null, val release_date: String? = null, val id: Int? = null, val adult: Boolean? = null, val backdrop_path: String? = null, val title: String? = null, val vote_average: Double? = null, val popularity: Double? = null, val vote_count: Int? = null)
@Serializable
data class MovieSearchRequest(val page: Int? = null, val primary_release_year: Int? = null, val query: String? = null, val region: String? = null, val year: Int? = null, val language: String? = null)
@Serializable
data class MovieSearchResponse(val page: Int? = null, val results: List<MovieMovieInfo>? = null, val total_pages: Int? = null, val total_results: Int? = null)
