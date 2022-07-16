
package com.m3o.m3okotlin.services.analytics

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "analytics"

object AnalyticsService {
      suspend fun delete(req: AnalyticsDeleteRequest): AnalyticsDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
      }
      suspend fun list(): AnalyticsListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) 
      }
      suspend fun read(req: AnalyticsReadRequest): AnalyticsReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = req
        }
      }
      suspend fun track(req: AnalyticsTrackRequest){
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
data class AnalyticsEvent(val value: Long, val created: String, val name: String)
@Serializable
data class AnalyticsListResponse(val events: List<AnalyticsEvent>)
@Serializable
data class AnalyticsReadRequest(val name: String)
@Serializable
data class AnalyticsReadResponse(val event: AnalyticsEvent)
@Serializable
data class AnalyticsTrackRequest(val name: String)
