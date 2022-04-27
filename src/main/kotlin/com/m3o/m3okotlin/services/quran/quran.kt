
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
internal data class QuranChapter()
@Serializable
internal data class QuranChaptersRequest()
@Serializable
data class QuranChaptersResponse()
@Serializable
internal data class QuranInterpretation()
@Serializable
internal data class QuranResult()
@Serializable
internal data class QuranSearchRequest()
@Serializable
data class QuranSearchResponse()
@Serializable
internal data class QuranSummaryRequest()
@Serializable
data class QuranSummaryResponse()
@Serializable
internal data class QuranTranslation()
@Serializable
internal data class QuranVerse()
@Serializable
internal data class QuranVersesRequest()
@Serializable
data class QuranVersesResponse()
@Serializable
internal data class QuranWord()
