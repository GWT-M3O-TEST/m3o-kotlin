
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "analytics"

object AnalyticsService {
    suspend fun delete(name: String): AnalyticsDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = AnalyticsDeleteRequest(name)
        }
    }
    suspend fun list(name: String): AnalyticsListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = AnalyticsListRequest(name)
        }
    }
    suspend fun read(name: String): AnalyticsReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = AnalyticsReadRequest(name)
        }
    }
    suspend fun track(name: String): AnalyticsTrackResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Track")) {
          body = AnalyticsTrackRequest(name)
        }
    }
}
@Serializable
internal data class AnalyticsDeleteRequest(val name: String)
@Serializable
data class AnalyticsDeleteResponse(val event: AnalyticsEvent)
@Serializable
internal data class AnalyticsEvent(val created: String, val name: String, val value: Long)
@Serializable
internal data class AnalyticsListRequest()
@Serializable
data class AnalyticsListResponse(val events: List<AnalyticsEvent>)
@Serializable
internal data class AnalyticsReadRequest(val name: String)
@Serializable
data class AnalyticsReadResponse(val event: AnalyticsEvent)
@Serializable
internal data class AnalyticsTrackRequest(val name: String)
@Serializable
data class AnalyticsTrackResponse()
