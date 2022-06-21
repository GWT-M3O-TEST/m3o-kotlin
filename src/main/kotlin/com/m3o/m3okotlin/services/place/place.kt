
package com.m3o.m3okotlin.services.place

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
}
    suspend fun search(req: PlaceSearchRequest): PlaceSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = req
        }
    }
}
