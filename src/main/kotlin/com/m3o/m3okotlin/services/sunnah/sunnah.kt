
package com.m3o.m3okotlin.services.sunnah

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "sunnah"

object SunnahService {
    suspend fun books(req: SunnahBooksRequest): SunnahBooksResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Books")) {
          body = req
        }
    }
    suspend fun chapters(req: SunnahChaptersRequest): SunnahChaptersResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Chapters")) {
          body = req
        }
    }
    suspend fun collections(req: SunnahCollectionsRequest): SunnahCollectionsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Collections")) {
          body = req
        }
    }
    suspend fun hadiths(req: SunnahHadithsRequest): SunnahHadithsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Hadiths")) {
          body = req
        }
    }
}
@Serializable
data class SunnahBook(val arabic_name: String, val hadiths: Int, val id: Int, val name: String)
@Serializable
data class SunnahBooksRequest(val collection: String, val limit: Int, val page: Int)
@Serializable
data class SunnahBooksResponse(val books: List<SunnahBook>, val collection: String, val limit: Int, val page: Int, val total: Int)
@Serializable
data class SunnahChapter(val key: String, val title: String, val arabic_title: String, val book: Int, val id: Int)
@Serializable
data class SunnahChaptersRequest(val limit: Int, val page: Int, val book: Int, val collection: String)
@Serializable
data class SunnahChaptersResponse(val page: Int, val total: Int, val book: Int, val chapters: List<SunnahChapter>, val collection: String, val limit: Int)
@Serializable
data class SunnahCollection(val name: String, val summary: String, val title: String, val arabic_title: String, val hadiths: Int)
@Serializable
data class SunnahCollectionsRequest(val limit: Int, val page: Int)
@Serializable
data class SunnahCollectionsResponse(val collections: List<SunnahCollection>)
@Serializable
data class SunnahHadith(val id: Int, val text: String, val arabic_chapter_title: String, val arabic_text: String, val chapter: Int, val chapter_key: String, val chapter_title: String)
@Serializable
data class SunnahHadithsRequest(val collection: String, val limit: Int, val page: Int, val book: Int)
@Serializable
data class SunnahHadithsResponse(val book: Int, val collection: String, val hadiths: List<SunnahHadith>, val limit: Int, val page: Int, val total: Int)
