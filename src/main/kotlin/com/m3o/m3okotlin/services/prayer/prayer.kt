
package com.m3o.m3okotlin.services.prayer

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "prayer"

object PrayerServ {
      suspend fun times(req: PrayerTimesRequest): PrayerTimesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Times")) {
          body = req
        }
      }
}
@Serializable
data class PrayerPrayerTime(val asr: String? = null, val date: String? = null, val fajr: String? = null, val isha: String? = null, val maghrib: String? = null, val sunrise: String? = null, val zuhr: String? = null)
@Serializable
data class PrayerTimesRequest(val days: Int? = null, val latitude: Double? = null, val location: String? = null, val longitude: Double? = null, val date: String? = null)
@Serializable
data class PrayerTimesResponse(val times: List<PrayerPrayerTime>? = null, val date: String? = null, val days: Int? = null, val latitude: Double? = null, val location: String? = null, val longitude: Double? = null)
