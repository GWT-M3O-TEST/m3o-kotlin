
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
internal data class GeocodingAddress()
@Serializable
internal data class GeocodingLocation()
@Serializable
internal data class GeocodingLookupRequest()
@Serializable
data class GeocodingLookupResponse()
@Serializable
internal data class GeocodingReverseRequest()
@Serializable
data class GeocodingReverseResponse()
