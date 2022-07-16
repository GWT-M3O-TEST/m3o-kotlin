
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

object PrayerService {
      suspend fun times(req: PrayerTimesRequest): PrayerTimesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Times")) {
          body = req
        }
      }
}
@Serializable
data class PrayerPrayerTime(val zuhr: String, val asr: String, val date: String, val fajr: String, val isha: String, val maghrib: String, val sunrise: String)
@Serializable
data class PrayerTimesRequest(val longitude: Double, val date: String, val days: Int, val latitude: Double, val location: String)
@Serializable
data class PrayerTimesResponse(val times: List<PrayerPrayerTime>, val date: String, val days: Int, val latitude: Double, val location: String, val longitude: Double)
