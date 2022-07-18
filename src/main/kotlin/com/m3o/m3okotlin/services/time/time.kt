
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
data class TimeNowRequest(val location: String? = null)
@Serializable
data class TimeNowResponse(val localtime: String? = null, val location: String? = null, val timestamp: String? = null, val timezone: String? = null, val unix: Long? = null)
@Serializable
data class TimeZoneRequest(val location: String? = null)
@Serializable
data class TimeZoneResponse(val dst: Boolean? = null, val latitude: Double? = null, val localtime: String? = null, val timezone: String? = null, val abbreviation: String? = null, val country: String? = null, val offset: Int? = null, val region: String? = null, val location: String? = null, val longitude: Double? = null)
