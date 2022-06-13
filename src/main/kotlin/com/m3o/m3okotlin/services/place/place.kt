
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
    suspend fun nearby(req: PlaceNearbyRequest): PlaceNearbyResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Nearby")) {
          body = req
        }
    }
    suspend fun search(req: PlaceSearchRequest): PlaceSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = req
        }
    }
}
@Serializable
internal data class PlaceAutocompleteRequest()
@Serializable
data class PlaceAutocompleteResponse()
@Serializable
internal data class PlaceNearbyRequest(val location: String, val name: String, val open_now: Boolean, val radius: Int, val type: String, val keyword: String)
@Serializable
data class PlaceNearbyResponse(val results: List<PlaceResult>)
@Serializable
internal data class PlaceResult(val open_now: Boolean, val opening_hours: List<PlaceString>, val rating: Double, val type: String, val icon_url: String, val name: String, val types: List<PlaceString>, val vicinity: String, val address: String, val location: String)
@Serializable
internal data class PlaceSearchRequest(val type: String, val location: String, val open_now: Boolean, val query: String, val radius: Int)
@Serializable
data class PlaceSearchResponse(val results: List<PlaceResult>)
