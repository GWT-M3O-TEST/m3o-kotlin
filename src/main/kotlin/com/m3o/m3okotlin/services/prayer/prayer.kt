
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "prayer"

object PrayerService {
    suspend fun times(name: String): PrayerTimesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Times")) {
          body = PrayerTimesRequest(name)
        }
    }
}
@Serializable
internal data class PrayerPrayerTime({/// date for prayer times in YYYY-MM-DD format
String? date, /// fajr time
String? fajr, /// isha time
String? isha, /// maghrib time
String? maghrib, /// time of sunrise
String? sunrise, /// zuhr time
String? zuhr, /// asr time
String? asr,})
@Serializable
internal data class PrayerTimesRequest({/// number of days to request times for
int? days, /// optional latitude used in place of location
double? latitude, /// location to retrieve prayer times for.
/// this can be a specific address, city, etc
String? location, /// optional longitude used in place of location
double? longitude, /// optional date in YYYY-MM-DD format, otherwise uses today
String? date,})
@Serializable
data class PrayerTimesResponse({/// longitude of location
double? longitude, /// prayer times for the given location
List<PrayerTime>? times, /// date of request
String? date, /// number of days
int? days, /// latitude of location
double? latitude, /// location for the request
String? location,})
