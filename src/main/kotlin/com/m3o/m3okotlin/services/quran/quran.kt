
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
data class QuranChapter(val prefix_bismillah: Boolean, val revelation_order: Int, val translated_name: String, val arabic_name: String, val complex_name: String, val id: Int, val verses: Int, val name: String, val pages: List<QuranInt>, val revelation_place: String)
@Serializable
data class QuranChaptersRequest(val language: String)
@Serializable
data class QuranChaptersResponse(val chapters: List<QuranChapter>)
@Serializable
data class QuranInterpretation(val id: Int, val source: String, val text: String)
@Serializable
data class QuranResult(val verse_id: Int, val verse_key: String, val text: String, val translations: List<QuranTranslation>)
@Serializable
data class QuranSearchRequest(val language: String, val limit: Int, val page: Int, val query: String)
@Serializable
data class QuranSearchResponse(val page: Int, val query: String, val results: List<QuranResult>, val total_pages: Int, val total_results: Int)
@Serializable
data class QuranSummaryRequest(val chapter: Int, val language: String)
@Serializable
data class QuranSummaryResponse(val source: String, val summary: String, val text: String, val chapter: Int)
@Serializable
data class QuranTranslation(val id: Int, val source: String, val text: String)
@Serializable
data class QuranVerse(val id: Int, val interpretations: List<QuranInterpretation>, val page: Int, val translated_text: String, val translations: List<QuranTranslation>, val key: String, val number: Int, val text: String, val transliteration: String, val words: List<QuranWord>)
@Serializable
data class QuranVersesRequest(val language: String, val limit: Int, val page: Int, val translate: Boolean, val words: Boolean, val chapter: Int, val interpret: Boolean)
@Serializable
data class QuranVersesResponse(val chapter: Int, val page: Int, val total_pages: Int, val verses: List<QuranVerse>)
@Serializable
data class QuranWord(val code: String, val transliteration: String, val page: Int, val position: Int, val text: String, val translation: String, val char_type: String, val id: Int, val line: Int)
