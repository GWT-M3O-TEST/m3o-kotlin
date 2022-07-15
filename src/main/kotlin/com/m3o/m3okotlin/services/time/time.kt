
package com.m3o.m3okotlin.services.time

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
data class TimeNowRequest(val location: String)
@Serializable
data class TimeNowResponse(val timezone: String, val unix: Long, val localtime: String, val location: String, val timestamp: String)
@Serializable
data class TimeZoneRequest(val location: String)
@Serializable
data class TimeZoneResponse(val abbreviation: String, val country: String, val latitude: Double, val longitude: Double, val offset: Int, val timezone: String, val dst: Boolean, val localtime: String, val location: String, val region: String)
