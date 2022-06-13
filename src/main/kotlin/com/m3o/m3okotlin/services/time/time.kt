
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
    suspend fun now(req: TimeNowRequest): TimeNowResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Now")) {
          body = req
        }
    }
    suspend fun zone(req: TimeZoneRequest): TimeZoneResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Zone")) {
          body = req
        }
    }
}
@Serializable
internal data class TimeNowRequest(val location: String)
@Serializable
data class TimeNowResponse(val localtime: String, val location: String, val timestamp: String, val timezone: String, val unix: Long)
@Serializable
internal data class TimeZoneRequest(val location: String)
@Serializable
data class TimeZoneResponse(val dst: Boolean, val latitude: Double, val location: String, val offset: Int, val timezone: String, val country: String, val localtime: String, val longitude: Double, val region: String, val abbreviation: String)
