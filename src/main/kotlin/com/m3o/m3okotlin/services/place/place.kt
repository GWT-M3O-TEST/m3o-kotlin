
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
internal data class PlaceNearbyRequest({/// radius in meters within which to search
int? radius, /// Type of place. https://developers.google.com/maps/documentation/places/web-service/supported_types
String? type, /// Keyword to include in the search
String? keyword, /// specify the location by lat,lng e.g -33.8670522,-151.1957362
String? location, /// Name of the place to search for
String? name, /// Whether the place is open now
bool? open_now,})
@Serializable
data class PlaceNearbyResponse({List<Result>? results,})
@Serializable
internal data class PlaceResult({/// name of the place
String? name, /// rating from 1.0 to 5.0
double? rating, /// feature types
List<String>? types, /// address of place
String? address, /// url of an icon
String? icon_url, /// lat/lng of place
String? location, /// open now
bool? open_now, /// opening hours
List<String>? opening_hours, /// type of location
String? type, /// simplified address
String? vicinity,})
@Serializable
internal data class PlaceSearchRequest({/// the location by lat,lng e.g -33.8670522,-151.1957362
String? location, /// Whether the place is open now
bool? open_now, /// the text string on which to search, for example: "restaurant"
String? query, /// radius in meters within which to search
int? radius, /// Type of place. https://developers.google.com/maps/documentation/places/web-service/supported_types
String? type,})
@Serializable
data class PlaceSearchResponse({List<Result>? results,})
