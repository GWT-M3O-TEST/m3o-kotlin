
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "time"

object TimeService {
    suspend fun now(name: String): TimeNowResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Now")) {
          body = TimeNowRequest(name)
        }
    }
    suspend fun zone(name: String): TimeZoneResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Zone")) {
          body = TimeZoneRequest(name)
        }
    }
}
@Serializable
internal data class TimeNowRequest()
@Serializable
data class TimeNowResponse()
@Serializable
internal data class TimeZoneRequest()
@Serializable
data class TimeZoneResponse()
