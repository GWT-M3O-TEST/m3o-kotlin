
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "location"

object LocationService {
    suspend fun read(name: String): LocationReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = LocationReadRequest(name)
        }
    }
    suspend fun save(name: String): LocationSaveResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Save")) {
          body = LocationSaveRequest(name)
        }
    }
    suspend fun search(name: String): LocationSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = LocationSearchRequest(name)
        }
    }
}
@Serializable
internal data class LocationEntity()
@Serializable
internal data class LocationPoint()
@Serializable
internal data class LocationReadRequest()
@Serializable
data class LocationReadResponse()
@Serializable
internal data class LocationSaveRequest()
@Serializable
data class LocationSaveResponse()
@Serializable
internal data class LocationSearchRequest()
@Serializable
data class LocationSearchResponse()
