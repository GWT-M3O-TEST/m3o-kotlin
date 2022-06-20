
package com.m3o.m3okotlin.services.analytics

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "analytics"

object AnalyticsService {
    suspend fun delete(req: AnalyticsDeleteRequest): AnalyticsDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
    }
    suspend fun list(req: AnalyticsListRequest): AnalyticsListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = req
        }
    }
    suspend fun read(req: AnalyticsReadRequest): AnalyticsReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = req
        }
    }
    suspend fun track(req: AnalyticsTrackRequest): AnalyticsTrackResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Track")) {
          body = req
        }
    }
}
@Serializable
data class AnalyticsDeleteRequest(val name: String)
@Serializable
data class AnalyticsDeleteResponse(val event: AnalyticsEvent)
@Serializable
data class AnalyticsEvent(val created: String, val name: String, val value: Long)
@Serializable
data class AnalyticsListRequest()
@Serializable
data class AnalyticsListResponse(val events: List<AnalyticsEvent>)
@Serializable
data class AnalyticsReadRequest(val name: String)
@Serializable
data class AnalyticsReadResponse(val event: AnalyticsEvent)
@Serializable
data class AnalyticsTrackRequest(val name: String)
@Serializable
data class AnalyticsTrackResponse()
