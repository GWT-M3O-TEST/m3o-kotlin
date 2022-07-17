
package com.m3o.m3okotlin.services.time

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "time"

object TimeServ {
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
data class TimeNowResponse(val timestamp: String, val timezone: String, val unix: Long, val localtime: String, val location: String)
@Serializable
data class TimeZoneRequest(val location: String)
@Serializable
data class TimeZoneResponse(val country: String, val localtime: String, val region: String, val timezone: String, val abbreviation: String, val dst: Boolean, val latitude: Double, val location: String, val longitude: Double, val offset: Int)
