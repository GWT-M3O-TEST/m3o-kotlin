
package com.m3o.m3okotlin.services.geocoding

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "geocoding"

object GeocodingServ {
      suspend fun lookup(req: GeocodingLookupRequest): GeocodingLookupResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Lookup")) {
          body = req
        }
      }
      suspend fun reverse(req: GeocodingReverseRequest): GeocodingReverseResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Reverse")) {
          body = req
        }
      }
}
@Serializable
data class GeocodingAddress(val line_two: String? = null, val postcode: String? = null, val city: String? = null, val country: String? = null, val line_one: String? = null)
@Serializable
data class GeocodingLocation(val latitude: Double? = null, val longitude: Double? = null)
@Serializable
data class GeocodingLookupRequest(val postcode: String? = null, val address: String? = null, val city: String? = null, val country: String? = null)
@Serializable
data class GeocodingLookupResponse(val address: GeocodingAddress? = null, val location: GeocodingLocation? = null)
@Serializable
data class GeocodingReverseRequest(val latitude: Double? = null, val longitude: Double? = null)
@Serializable
data class GeocodingReverseResponse(val address: GeocodingAddress? = null, val location: GeocodingLocation? = null)
