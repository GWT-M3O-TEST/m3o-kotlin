
package com.m3o.m3okotlin.services.movie

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "movie"

object MovieService {
    suspend fun search(req: MovieSearchRequest): MovieSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = req
        }
    }
}
@Serializable
data class MovieMovieInfo(val original_title: String, val vote_count: Int, val genre_ids: List<MovieInt>, val id: Int, val popularity: Double, val poster_path: String, val video: Boolean, val vote_average: Double, val adult: Boolean, val backdrop_path: String, val original_language: String, val overview: String, val release_date: String, val title: String)
@Serializable
data class MovieSearchRequest(val query: String, val region: String, val year: Int, val language: String, val page: Int, val primary_release_year: Int)
@Serializable
data class MovieSearchResponse(val page: Int, val results: List<MovieMovieInfo>, val total_pages: Int, val total_results: Int)
