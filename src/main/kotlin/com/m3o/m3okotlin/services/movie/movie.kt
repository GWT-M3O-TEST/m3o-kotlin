
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
internal data class MovieMovieInfo({int? id, double? popularity, double? vote_average, String? overview, String? title, String? release_date, bool? video, bool? adult, String? backdrop_path, String? original_title, String? poster_path, List<int>? genre_ids, String? original_language, int? vote_count,})
@Serializable
internal data class MovieSearchRequest({/// a ISO 639-1 value to display translated data
String? language, /// page to query
int? page, /// year of release
int? primary_release_year, /// a text query to search
String? query, /// a ISO 3166-1 code to filter release dates.
String? region, /// year of making
int? year,})
@Serializable
data class MovieSearchResponse({int? page, List<MovieInfo>? results, int? total_pages, int? total_results,})
