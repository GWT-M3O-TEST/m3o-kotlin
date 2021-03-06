
package com.m3o.m3okotlin.services.location

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "location"

object LocationServ {
      suspend fun read(req: LocationReadRequest): LocationReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = req
        }
      }
      suspend fun save(req: LocationSaveRequest){
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
data class LocationEntity(val id: String? = null, val location: LocationPoint? = null, val type: String? = null)
@Serializable
data class LocationPoint(val latitude: Double? = null, val longitude: Double? = null, val timestamp: Long? = null)
@Serializable
data class LocationReadRequest(val id: String? = null)
@Serializable
data class LocationReadResponse(val entity: LocationEntity? = null)
@Serializable
data class LocationSaveRequest(val entity: LocationEntity? = null)
@Serializable
data class LocationSearchRequest(val center: LocationPoint? = null, val numEntities: Long? = null, val radius: Double? = null, val type: String? = null)
@Serializable
data class LocationSearchResponse(val entities: List<LocationEntity>? = null)
