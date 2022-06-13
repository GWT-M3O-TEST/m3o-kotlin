
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
internal data class SunnahBook(val arabic_name: String, val hadiths: Int, val id: Int, val name: String)
@Serializable
internal data class SunnahBooksRequest(val collection: String, val limit: Int, val page: Int)
@Serializable
data class SunnahBooksResponse(val books: List<SunnahBook>, val collection: String, val limit: Int, val page: Int, val total: Int)
@Serializable
internal data class SunnahChapter(val arabic_title: String, val book: Int, val id: Int, val key: String, val title: String)
@Serializable
internal data class SunnahChaptersRequest(val book: Int, val collection: String, val limit: Int, val page: Int)
@Serializable
data class SunnahChaptersResponse(val total: Int, val book: Int, val chapters: List<SunnahChapter>, val collection: String, val limit: Int, val page: Int)
@Serializable
internal data class SunnahCollection(val arabic_title: String, val hadiths: Int, val name: String, val summary: String, val title: String)
@Serializable
internal data class SunnahCollectionsRequest(val limit: Int, val page: Int)
@Serializable
data class SunnahCollectionsResponse(val collections: List<SunnahCollection>)
@Serializable
internal data class SunnahHadith(val id: Int, val text: String, val arabic_chapter_title: String, val arabic_text: String, val chapter: Int, val chapter_key: String, val chapter_title: String)
@Serializable
internal data class SunnahHadithsRequest(val limit: Int, val page: Int, val book: Int, val collection: String)
@Serializable
data class SunnahHadithsResponse(val book: Int, val collection: String, val hadiths: List<SunnahHadith>, val limit: Int, val page: Int, val total: Int)
