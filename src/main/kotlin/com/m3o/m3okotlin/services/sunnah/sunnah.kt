
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
    suspend fun books(name: String): SunnahBooksResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Books")) {
          body = SunnahBooksRequest(name)
        }
    }
    suspend fun chapters(name: String): SunnahChaptersResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Chapters")) {
          body = SunnahChaptersRequest(name)
        }
    }
    suspend fun collections(name: String): SunnahCollectionsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Collections")) {
          body = SunnahCollectionsRequest(name)
        }
    }
    suspend fun hadiths(name: String): SunnahHadithsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Hadiths")) {
          body = SunnahHadithsRequest(name)
        }
    }
}
@Serializable
internal data class SunnahBook()
@Serializable
internal data class SunnahBooksRequest()
@Serializable
data class SunnahBooksResponse()
@Serializable
internal data class SunnahChapter()
@Serializable
internal data class SunnahChaptersRequest()
@Serializable
data class SunnahChaptersResponse()
@Serializable
internal data class SunnahCollection()
@Serializable
internal data class SunnahCollectionsRequest()
@Serializable
data class SunnahCollectionsResponse()
@Serializable
internal data class SunnahHadith()
@Serializable
internal data class SunnahHadithsRequest()
@Serializable
data class SunnahHadithsResponse()
