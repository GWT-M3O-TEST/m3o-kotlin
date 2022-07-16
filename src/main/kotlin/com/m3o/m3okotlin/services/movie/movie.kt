
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
data class MovieMovieInfo(val genre_ids: List<Int>, val release_date: String, val title: String, val video: Boolean, val vote_count: Int, val popularity: Double, val vote_average: Double, val id: Int, val original_language: String, val overview: String, val poster_path: String, val adult: Boolean, val backdrop_path: String, val original_title: String)
@Serializable
data class MovieSearchRequest(val language: String, val page: Int, val primary_release_year: Int, val query: String, val region: String, val year: Int)
@Serializable
data class MovieSearchResponse(val results: List<MovieMovieInfo>, val total_pages: Int, val total_results: Int, val page: Int)
