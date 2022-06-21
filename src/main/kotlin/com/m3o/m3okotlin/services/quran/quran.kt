
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
}
    suspend fun search(req: QuranSearchRequest): QuranSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = req
        }
    }
}
    suspend fun summary(req: QuranSummaryRequest): QuranSummaryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Summary")) {
          body = req
        }
    }
}
    suspend fun verses(req: QuranVersesRequest): QuranVersesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Verses")) {
          body = req
        }
    }
}
