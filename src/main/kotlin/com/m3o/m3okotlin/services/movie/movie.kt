
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
internal data class MovieMovieInfo(val adult: Boolean, val id: Int, val video: Boolean, val title: String, val backdrop_path: String, val genre_ids: List<MovieInt>, val poster_path: String, val vote_average: Double, val vote_count: Int, val original_language: String, val original_title: String, val release_date: String, val overview: String, val popularity: Double)
@Serializable
internal data class MovieSearchRequest(val page: Int, val primary_release_year: Int, val query: String, val region: String, val year: Int, val language: String)
@Serializable
data class MovieSearchResponse(val total_pages: Int, val total_results: Int, val page: Int, val results: List<MovieMovieInfo>)
