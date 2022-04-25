
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "geocoding"

object GeocodingService {
    suspend fun lookup(name: String): GeocodingLookupResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Lookup")) {
          body = GeocodingLookupRequest(name)
        }
    }
    suspend fun reverse(name: String): GeocodingReverseResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Reverse")) {
          body = GeocodingReverseRequest(name)
        }
    }
}
@Serializable
internal data class GeocodingAddress({String? line_two, String? postcode, String? city, String? country, String? line_one,})
@Serializable
internal data class GeocodingLocation({double? latitude, double? longitude,})
@Serializable
internal data class GeocodingLookupRequest({String? address, String? city, String? country, String? postcode,})
@Serializable
data class GeocodingLookupResponse({Address? address, Location? location,})
@Serializable
internal data class GeocodingReverseRequest({double? latitude, double? longitude,})
@Serializable
data class GeocodingReverseResponse({Address? address, Location? location,})
