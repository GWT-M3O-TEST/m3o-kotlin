
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "sunnah"

object SunnahService {
    suspend fun books(name: String): SunnahBooksResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Books")) {
          body = SunnahBooksRequest(name)
        }
    }
    suspend fun chapters(name: String): SunnahChaptersResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Chapters")) {
          body = SunnahChaptersRequest(name)
        }
    }
    suspend fun collections(name: String): SunnahCollectionsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Collections")) {
          body = SunnahCollectionsRequest(name)
        }
    }
    suspend fun hadiths(name: String): SunnahHadithsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Hadiths")) {
          body = SunnahHadithsRequest(name)
        }
    }
}
@Serializable
internal data class SunnahBook(val arabic_name: String, val hadiths: Int, val id: Int, val name: String)
@Serializable
internal data class SunnahBooksRequest(val collection: String, val limit: Int, val page: Int)
@Serializable
data class SunnahBooksResponse(val books: List<SunnahBook>, val collection: String, val limit: Int, val page: Int, val total: Int)
@Serializable
internal data class SunnahChapter(val id: Int, val key: String, val title: String, val arabic_title: String, val book: Int)
@Serializable
internal data class SunnahChaptersRequest(val book: Int, val collection: String, val limit: Int, val page: Int)
@Serializable
data class SunnahChaptersResponse(val limit: Int, val page: Int, val total: Int, val book: Int, val chapters: List<SunnahChapter>, val collection: String)
@Serializable
internal data class SunnahCollection(val name: String, val summary: String, val title: String, val arabic_title: String, val hadiths: Int)
@Serializable
internal data class SunnahCollectionsRequest(val limit: Int, val page: Int)
@Serializable
data class SunnahCollectionsResponse(val collections: List<SunnahCollection>)
@Serializable
internal data class SunnahHadith(val arabic_chapter_title: String, val arabic_text: String, val chapter: Int, val chapter_key: String, val chapter_title: String, val id: Int, val text: String)
@Serializable
internal data class SunnahHadithsRequest(val book: Int, val collection: String, val limit: Int, val page: Int)
@Serializable
data class SunnahHadithsResponse(val total: Int, val book: Int, val collection: String, val hadiths: List<SunnahHadith>, val limit: Int, val page: Int)
