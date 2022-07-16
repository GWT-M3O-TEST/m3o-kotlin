
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

object MovieService {
      suspend fun search(req: MovieSearchRequest): MovieSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = req
        }
      }
}
@Serializable
data class MovieMovieInfo(val poster_path: String, val genre_ids: List<Int>, val original_title: String, val overview: String, val popularity: Double, val id: Int, val original_language: String, val title: String, val backdrop_path: String, val vote_average: Double, val vote_count: Int, val adult: Boolean, val release_date: String, val video: Boolean)
@Serializable
data class MovieSearchRequest(val query: String, val region: String, val year: Int, val language: String, val page: Int, val primary_release_year: Int)
@Serializable
data class MovieSearchResponse(val page: Int, val results: List<MovieMovieInfo>, val total_pages: Int, val total_results: Int)
