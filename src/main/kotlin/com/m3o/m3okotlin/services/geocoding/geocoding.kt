
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
internal data class GeocodingAddress(val city: String, val country: String, val line_one: String, val line_two: String, val postcode: String)
@Serializable
internal data class GeocodingLocation(val latitude: Double, val longitude: Double)
@Serializable
internal data class GeocodingLookupRequest(val address: String, val city: String, val country: String, val postcode: String)
@Serializable
data class GeocodingLookupResponse(val location: GeocodingLocation, val address: GeocodingAddress)
@Serializable
internal data class GeocodingReverseRequest(val latitude: Double, val longitude: Double)
@Serializable
data class GeocodingReverseResponse(val address: GeocodingAddress, val location: GeocodingLocation)
