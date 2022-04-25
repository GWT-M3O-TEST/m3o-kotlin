
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "routing"

object RoutingService {
    suspend fun directions(name: String): RoutingDirectionsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Directions")) {
          body = RoutingDirectionsRequest(name)
        }
    }
    suspend fun eta(name: String): RoutingEtaResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Eta")) {
          body = RoutingEtaRequest(name)
        }
    }
    suspend fun route(name: String): RoutingRouteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Route")) {
          body = RoutingRouteRequest(name)
        }
    }
}
@Serializable
internal data class RoutingDirection({/// distance to travel in meters
double? distance, /// duration to travel in seconds
double? duration, /// human readable instruction
String? instruction, /// intersections on route
List<Intersection>? intersections, /// maneuver to take
Maneuver? maneuver, /// street name or location
String? name, /// alternative reference
String? reference,})
@Serializable
internal data class RoutingDirectionsRequest({/// The destination of the journey
Point? destination, /// The staring point for the journey
Point? origin,})
@Serializable
data class RoutingDirectionsResponse({/// Turn by turn directions
List<Direction>? directions, /// Estimated distance of the route in meters
double? distance, /// Estimated duration of the route in seconds
double? duration, /// The waypoints on the route
List<Waypoint>? waypoints,})
@Serializable
internal data class RoutingEtaRequest({/// The end point for the eta calculation
Point? destination, /// The starting point for the eta calculation
Point? origin, /// speed in kilometers
double? speed, /// type of transport. Only "car" is supported currently.
String? type,})
@Serializable
data class RoutingEtaResponse({/// eta in seconds
double? duration,})
@Serializable
internal data class RoutingIntersection({List<double>? bearings, Point? location,})
@Serializable
internal data class RoutingManeuver({Point? location, String? action, double? bearing_after, double? bearing_before, String? direction,})
@Serializable
internal data class RoutingPoint({/// Lat e.g 52.523219
double? latitude, /// Long e.g 13.428555
double? longitude,})
@Serializable
internal data class RoutingRouteRequest({/// Point of destination for the trip
Point? destination, /// Point of origin for the trip
Point? origin,})
@Serializable
data class RoutingRouteResponse({/// estimated distance in meters
double? distance, /// estimated duration in seconds
double? duration, /// waypoints on the route
List<Waypoint>? waypoints,})
@Serializable
internal data class RoutingWaypoint({/// gps point coordinates
Point? location, /// street name or related reference
String? name,})
