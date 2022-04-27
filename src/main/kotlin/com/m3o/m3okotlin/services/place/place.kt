
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "place"

object PlaceService {
    suspend fun nearby(name: String): PlaceNearbyResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Nearby")) {
          body = PlaceNearbyRequest(name)
        }
    }
    suspend fun search(name: String): PlaceSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = PlaceSearchRequest(name)
        }
    }
}
@Serializable
internal data class PlaceAutocompleteRequest()
@Serializable
data class PlaceAutocompleteResponse()
@Serializable
internal data class PlaceNearbyRequest()
@Serializable
data class PlaceNearbyResponse()
@Serializable
internal data class PlaceResult()
@Serializable
internal data class PlaceSearchRequest()
@Serializable
data class PlaceSearchResponse()
