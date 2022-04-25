
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
internal data class AnalyticsDeleteRequest({String? name,})
@Serializable
data class AnalyticsDeleteResponse({Event? event,})
@Serializable
internal data class AnalyticsEvent({/// time at which the event was created
String? created, /// event name
String? name, /// the amount of times the event was triggered

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? value
	,})
@Serializable
internal data class AnalyticsListRequest()
@Serializable
data class AnalyticsListResponse({List<Event>? events,})
@Serializable
internal data class AnalyticsReadRequest({String? name,})
@Serializable
data class AnalyticsReadResponse({Event? event,})
@Serializable
internal data class AnalyticsTrackRequest({/// event name
String? name,})
@Serializable
data class AnalyticsTrackResponse()
