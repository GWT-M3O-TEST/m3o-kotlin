
package com.m3o.m3okotlin.services

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
internal data class QuranChapter(val complex_name: String, val id: Int, val name: String, val prefix_bismillah: Boolean, val revelation_order: Int, val translated_name: String, val arabic_name: String, val pages: List<QuranInt>, val revelation_place: String, val verses: Int)
@Serializable
internal data class QuranChaptersRequest(val language: String)
@Serializable
data class QuranChaptersResponse(val chapters: List<QuranChapter>)
@Serializable
internal data class QuranInterpretation(val id: Int, val source: String, val text: String)
@Serializable
internal data class QuranResult(val text: String, val translations: List<QuranTranslation>, val verse_id: Int, val verse_key: String)
@Serializable
internal data class QuranSearchRequest(val limit: Int, val page: Int, val query: String, val language: String)
@Serializable
data class QuranSearchResponse(val page: Int, val query: String, val results: List<QuranResult>, val total_pages: Int, val total_results: Int)
@Serializable
internal data class QuranSummaryRequest(val language: String, val chapter: Int)
@Serializable
data class QuranSummaryResponse(val chapter: Int, val source: String, val summary: String, val text: String)
@Serializable
internal data class QuranTranslation(val id: Int, val source: String, val text: String)
@Serializable
internal data class QuranVerse(val id: Int, val key: String, val number: Int, val transliteration: String, val words: List<QuranWord>, val interpretations: List<QuranInterpretation>, val page: Int, val text: String, val translated_text: String, val translations: List<QuranTranslation>)
@Serializable
internal data class QuranVersesRequest(val limit: Int, val page: Int, val translate: Boolean, val words: Boolean, val chapter: Int, val interpret: Boolean, val language: String)
@Serializable
data class QuranVersesResponse(val chapter: Int, val page: Int, val total_pages: Int, val verses: List<QuranVerse>)
@Serializable
internal data class QuranWord(val char_type: String, val code: String, val id: Int, val page: Int, val transliteration: String, val line: Int, val position: Int, val text: String, val translation: String)
