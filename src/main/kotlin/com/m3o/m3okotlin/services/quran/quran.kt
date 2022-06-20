
package com.m3o.m3okotlin.services.quran

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "quran"

object QuranService {
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
data class QuranChapter(val complex_name: String, val name: String, val pages: List<QuranInt>, val revelation_place: String, val translated_name: String, val arabic_name: String, val id: Int, val prefix_bismillah: Boolean, val revelation_order: Int, val verses: Int)
@Serializable
data class QuranChaptersRequest(val language: String)
@Serializable
data class QuranChaptersResponse(val chapters: List<QuranChapter>)
@Serializable
data class QuranInterpretation(val id: Int, val source: String, val text: String)
@Serializable
data class QuranResult(val verse_key: String, val text: String, val translations: List<QuranTranslation>, val verse_id: Int)
@Serializable
data class QuranSearchRequest(val language: String, val limit: Int, val page: Int, val query: String)
@Serializable
data class QuranSearchResponse(val page: Int, val query: String, val results: List<QuranResult>, val total_pages: Int, val total_results: Int)
@Serializable
data class QuranSummaryRequest(val chapter: Int, val language: String)
@Serializable
data class QuranSummaryResponse(val chapter: Int, val source: String, val summary: String, val text: String)
@Serializable
data class QuranTranslation(val text: String, val id: Int, val source: String)
@Serializable
data class QuranVerse(val translated_text: String, val translations: List<QuranTranslation>, val transliteration: String, val interpretations: List<QuranInterpretation>, val number: Int, val text: String, val words: List<QuranWord>, val id: Int, val key: String, val page: Int)
@Serializable
data class QuranVersesRequest(val words: Boolean, val chapter: Int, val interpret: Boolean, val language: String, val limit: Int, val page: Int, val translate: Boolean)
@Serializable
data class QuranVersesResponse(val total_pages: Int, val verses: List<QuranVerse>, val chapter: Int, val page: Int)
@Serializable
data class QuranWord(val line: Int, val position: Int, val translation: String, val transliteration: String, val id: Int, val code: String, val page: Int, val text: String, val char_type: String)
