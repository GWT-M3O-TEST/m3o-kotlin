
package com.m3o.m3okotlin.services.sunnah

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "sunnah"

object SunnahServ {
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
data class SunnahBook(val name: String? = null, val arabic_name: String? = null, val hadiths: Int? = null, val id: Int? = null)
@Serializable
data class SunnahBooksRequest(val collection: String? = null, val limit: Int? = null, val page: Int? = null)
@Serializable
data class SunnahBooksResponse(val books: List<SunnahBook>? = null, val collection: String? = null, val limit: Int? = null, val page: Int? = null, val total: Int? = null)
@Serializable
data class SunnahChapter(val title: String? = null, val arabic_title: String? = null, val book: Int? = null, val id: Int? = null, val key: String? = null)
@Serializable
data class SunnahChaptersRequest(val book: Int? = null, val collection: String? = null, val limit: Int? = null, val page: Int? = null)
@Serializable
data class SunnahChaptersResponse(val limit: Int? = null, val page: Int? = null, val total: Int? = null, val book: Int? = null, val chapters: List<SunnahChapter>? = null, val collection: String? = null)
@Serializable
data class SunnahCollection(val arabic_title: String? = null, val hadiths: Int? = null, val name: String? = null, val summary: String? = null, val title: String? = null)
@Serializable
data class SunnahCollectionsRequest(val limit: Int? = null, val page: Int? = null)
@Serializable
data class SunnahCollectionsResponse(val collections: List<SunnahCollection>? = null)
@Serializable
data class SunnahHadith(val arabic_text: String? = null, val chapter: Int? = null, val chapter_key: String? = null, val chapter_title: String? = null, val id: Int? = null, val text: String? = null, val arabic_chapter_title: String? = null)
@Serializable
data class SunnahHadithsRequest(val book: Int? = null, val collection: String? = null, val limit: Int? = null, val page: Int? = null)
@Serializable
data class SunnahHadithsResponse(val collection: String? = null, val hadiths: List<SunnahHadith>? = null, val limit: Int? = null, val page: Int? = null, val total: Int? = null, val book: Int? = null)
