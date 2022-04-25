
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
internal data class TimeNowRequest({/// optional location, otherwise returns UTC
String? location,})
@Serializable
data class TimeNowResponse({/// the current time as HH:MM:SS
String? localtime, /// the location as Europe/London
String? location, /// timestamp as 2006-01-02T15:04:05.999999999Z07:00
String? timestamp, /// the timezone as BST
String? timezone, /// the unix timestamp

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? unix
	,})
@Serializable
internal data class TimeZoneRequest({/// location to lookup e.g postcode, city, ip address
String? location,})
@Serializable
data class TimeZoneResponse({/// e.g 51.42
double? latitude, /// the local time
String? localtime, /// e.g -0.37
double? longitude, /// UTC offset in hours
int? offset, /// the abbreviated code e.g BST
String? abbreviation, /// is daylight savings
bool? dst, /// location requested
String? location, /// region of timezone
String? region, /// the timezone e.g Europe/London
String? timezone, /// country of the timezone
String? country,})
