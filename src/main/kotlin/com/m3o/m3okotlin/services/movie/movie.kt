
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "movie"

object MovieService {
    suspend fun search(name: String): MovieSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = MovieSearchRequest(name)
        }
    }
}
@Serializable
internal data class MovieMovieInfo(val backdrop_path: String, val genre_ids: List<MovieInt>, val popularity: Double, val release_date: String, val vote_count: Int, val adult: Boolean, val original_title: String, val vote_average: Double, val original_language: String, val overview: String, val video: Boolean, val id: Int, val title: String, val poster_path: String)
@Serializable
internal data class MovieSearchRequest(val language: String, val page: Int, val primary_release_year: Int, val query: String, val region: String, val year: Int)
@Serializable
data class MovieSearchResponse(val page: Int, val results: List<MovieMovieInfo>, val total_pages: Int, val total_results: Int)
