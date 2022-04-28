
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
internal data class RoutingDirection(val duration: Double, val instruction: String, val intersections: List<RoutingIntersection>, val maneuver: RoutingManeuver, val name: String, val reference: String, val distance: Double)
@Serializable
internal data class RoutingDirectionsRequest(val destination: RoutingPoint, val origin: RoutingPoint)
@Serializable
data class RoutingDirectionsResponse(val distance: Double, val duration: Double, val waypoints: List<RoutingWaypoint>, val directions: List<RoutingDirection>)
@Serializable
internal data class RoutingEtaRequest(val destination: RoutingPoint, val origin: RoutingPoint, val speed: Double, val type: String)
@Serializable
data class RoutingEtaResponse(val duration: Double)
@Serializable
internal data class RoutingIntersection(val bearings: List<RoutingDouble>, val location: RoutingPoint)
@Serializable
internal data class RoutingManeuver(val action: String, val bearing_after: Double, val bearing_before: Double, val direction: String, val location: RoutingPoint)
@Serializable
internal data class RoutingPoint(val latitude: Double, val longitude: Double)
@Serializable
internal data class RoutingRouteRequest(val origin: RoutingPoint, val destination: RoutingPoint)
@Serializable
data class RoutingRouteResponse(val distance: Double, val duration: Double, val waypoints: List<RoutingWaypoint>)
@Serializable
internal data class RoutingWaypoint(val location: RoutingPoint, val name: String)
