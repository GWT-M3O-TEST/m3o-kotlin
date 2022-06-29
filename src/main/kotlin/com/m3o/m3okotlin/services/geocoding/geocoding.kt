
package com.m3o.m3okotlin.services.geocoding

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "geocoding"

object GeocodingService {
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
data class GeocodingAddress(val postcode: String, val city: String, val country: String, val line_one: String, val line_two: String)
@Serializable
data class GeocodingLocation(val latitude: Double, val longitude: Double)
@Serializable
data class GeocodingLookupRequest(val country: String, val postcode: String, val address: String, val city: String)
@Serializable
data class GeocodingLookupResponse(val address: GeocodingAddress, val location: GeocodingLocation)
@Serializable
data class GeocodingReverseRequest(val latitude: Double, val longitude: Double)
@Serializable
data class GeocodingReverseResponse(val address: GeocodingAddress, val location: GeocodingLocation)
