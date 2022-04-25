
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
internal data class LocationEntity({String? type, String? id, Point? location,})
@Serializable
internal data class LocationPoint({double? latitude, double? longitude, 
	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? timestamp
	,})
@Serializable
internal data class LocationReadRequest({/// the entity id
String? id,})
@Serializable
data class LocationReadResponse({Entity? entity,})
@Serializable
internal data class LocationSaveRequest({Entity? entity,})
@Serializable
data class LocationSaveResponse()
@Serializable
internal data class LocationSearchRequest({/// Maximum number of entities to return

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? numEntities
	, /// radius in meters
double? radius, /// type of entities to filter
String? type, /// Central position to search from
Point? center,})
@Serializable
data class LocationSearchResponse({List<Entity>? entities,})
