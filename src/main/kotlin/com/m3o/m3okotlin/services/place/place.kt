
package com.m3o.m3okotlin.services.place

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "place"

object PlaceServ {
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
data class PlaceNearbyRequest(val type: String? = null, val keyword: String? = null, val location: String? = null, val name: String? = null, val open_now: Boolean? = null, val radius: Int? = null)
@Serializable
data class PlaceNearbyResponse(val results: List<PlaceResult>? = null)
@Serializable
data class PlaceResult(val icon_url: String? = null, val name: String? = null, val opening_hours: List<String>? = null, val rating: Double? = null, val type: String? = null, val address: String? = null, val location: String? = null, val open_now: Boolean? = null, val types: List<String>? = null, val vicinity: String? = null)
@Serializable
data class PlaceSearchRequest(val location: String? = null, val open_now: Boolean? = null, val query: String? = null, val radius: Int? = null, val type: String? = null)
@Serializable
data class PlaceSearchResponse(val results: List<PlaceResult>? = null)
