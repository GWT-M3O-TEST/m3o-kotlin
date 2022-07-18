
package com.m3o.m3okotlin.services.quran

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "quran"

object QuranServ {
      suspend fun chapters(req: QuranChaptersRequest): QuranChaptersResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Chapters")) {
          body = req
        }
      }
      suspend fun search(req: QuranSearchRequest): QuranSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = req
        }
      }
      suspend fun summary(req: QuranSummaryRequest): QuranSummaryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Summary")) {
          body = req
        }
      }
      suspend fun verses(req: QuranVersesRequest): QuranVersesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Verses")) {
          body = req
        }
      }
}
@Serializable
data class QuranChapter(val name: String? = null, val pages: List<Int>? = null, val revelation_order: Int? = null, val revelation_place: String? = null, val verses: Int? = null, val arabic_name: String? = null, val complex_name: String? = null, val id: Int? = null, val prefix_bismillah: Boolean? = null, val translated_name: String? = null)
@Serializable
data class QuranChaptersRequest(val language: String? = null)
@Serializable
data class QuranChaptersResponse(val chapters: List<QuranChapter>? = null)
@Serializable
data class QuranInterpretation(val source: String? = null, val text: String? = null, val id: Int? = null)
@Serializable
data class QuranResult(val text: String? = null, val translations: List<QuranTranslation>? = null, val verse_id: Int? = null, val verse_key: String? = null)
@Serializable
data class QuranSearchRequest(val page: Int? = null, val query: String? = null, val language: String? = null, val limit: Int? = null)
@Serializable
data class QuranSearchResponse(val page: Int? = null, val query: String? = null, val results: List<QuranResult>? = null, val total_pages: Int? = null, val total_results: Int? = null)
@Serializable
data class QuranSummaryRequest(val language: String? = null, val chapter: Int? = null)
@Serializable
data class QuranSummaryResponse(val chapter: Int? = null, val source: String? = null, val summary: String? = null, val text: String? = null)
@Serializable
data class QuranTranslation(val id: Int? = null, val source: String? = null, val text: String? = null)
@Serializable
data class QuranVerse(val id: Int? = null, val text: String? = null, val translations: List<QuranTranslation>? = null, val words: List<QuranWord>? = null, val transliteration: String? = null, val interpretations: List<QuranInterpretation>? = null, val key: String? = null, val number: Int? = null, val page: Int? = null, val translated_text: String? = null)
@Serializable
data class QuranVersesRequest(val language: String? = null, val limit: Int? = null, val page: Int? = null, val translate: Boolean? = null, val words: Boolean? = null, val chapter: Int? = null, val interpret: Boolean? = null)
@Serializable
data class QuranVersesResponse(val chapter: Int? = null, val page: Int? = null, val total_pages: Int? = null, val verses: List<QuranVerse>? = null)
@Serializable
data class QuranWord(val id: Int? = null, val line: Int? = null, val position: Int? = null, val char_type: String? = null, val code: String? = null, val translation: String? = null, val transliteration: String? = null, val page: Int? = null, val text: String? = null)
