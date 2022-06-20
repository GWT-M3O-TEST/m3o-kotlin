
package com.m3o.m3okotlin.services.location

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "location"

object LocationService {
    suspend fun read(req: LocationReadRequest): LocationReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = req
        }
    }
    suspend fun save(req: LocationSaveRequest): LocationSaveResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Save")) {
          body = req
        }
    }
    suspend fun search(req: LocationSearchRequest): LocationSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = req
        }
    }
}
@Serializable
data class LocationEntity(val id: String, val location: LocationPoint, val type: String)
@Serializable
data class LocationPoint(val latitude: Double, val longitude: Double, val timestamp: Long)
@Serializable
data class LocationReadRequest(val id: String)
@Serializable
data class LocationReadResponse(val entity: LocationEntity)
@Serializable
data class LocationSaveRequest(val entity: LocationEntity)
@Serializable
data class LocationSaveResponse()
@Serializable
data class LocationSearchRequest(val center: LocationPoint, val numEntities: Long, val radius: Double, val type: String)
@Serializable
data class LocationSearchResponse(val entities: List<LocationEntity>)
