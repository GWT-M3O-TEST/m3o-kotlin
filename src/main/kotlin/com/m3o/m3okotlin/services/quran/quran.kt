
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
    suspend fun chapters(name: String): QuranChaptersResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Chapters")) {
          body = QuranChaptersRequest(name)
        }
    }
    suspend fun search(name: String): QuranSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = QuranSearchRequest(name)
        }
    }
    suspend fun summary(name: String): QuranSummaryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Summary")) {
          body = QuranSummaryRequest(name)
        }
    }
    suspend fun verses(name: String): QuranVersesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Verses")) {
          body = QuranVersesRequest(name)
        }
    }
}
@Serializable
internal data class QuranChapter(val complex_name: String, val revelation_order: Int, val revelation_place: String, val verses: Int, val translated_name: String, val arabic_name: String, val id: Int, val name: String, val pages: List<QuranInt>, val prefix_bismillah: Boolean)
@Serializable
internal data class QuranChaptersRequest(val language: String)
@Serializable
data class QuranChaptersResponse(val chapters: List<QuranChapter>)
@Serializable
internal data class QuranInterpretation(val source: String, val text: String, val id: Int)
@Serializable
internal data class QuranResult(val text: String, val translations: List<QuranTranslation>, val verse_id: Int, val verse_key: String)
@Serializable
internal data class QuranSearchRequest(val language: String, val limit: Int, val page: Int, val query: String)
@Serializable
data class QuranSearchResponse(val total_pages: Int, val total_results: Int, val page: Int, val query: String, val results: List<QuranResult>)
@Serializable
internal data class QuranSummaryRequest(val chapter: Int, val language: String)
@Serializable
data class QuranSummaryResponse(val chapter: Int, val source: String, val summary: String, val text: String)
@Serializable
internal data class QuranTranslation(val source: String, val text: String, val id: Int)
@Serializable
internal data class QuranVerse(val interpretations: List<QuranInterpretation>, val page: Int, val translated_text: String, val translations: List<QuranTranslation>, val id: Int, val key: String, val number: Int, val text: String, val transliteration: String, val words: List<QuranWord>)
@Serializable
internal data class QuranVersesRequest(val language: String, val limit: Int, val page: Int, val translate: Boolean, val words: Boolean, val chapter: Int, val interpret: Boolean)
@Serializable
data class QuranVersesResponse(val chapter: Int, val page: Int, val total_pages: Int, val verses: List<QuranVerse>)
@Serializable
internal data class QuranWord(val line: Int, val translation: String, val text: String, val transliteration: String, val char_type: String, val code: String, val id: Int, val page: Int, val position: Int)
