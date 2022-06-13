
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
    suspend fun directions(req: RoutingDirectionsRequest): RoutingDirectionsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Directions")) {
          body = req
        }
    }
    suspend fun eta(req: RoutingEtaRequest): RoutingEtaResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Eta")) {
          body = req
        }
    }
    suspend fun route(req: RoutingRouteRequest): RoutingRouteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Route")) {
          body = req
        }
    }
}
@Serializable
internal data class RoutingDirection(val name: String, val reference: String, val distance: Double, val duration: Double, val instruction: String, val intersections: List<RoutingIntersection>, val maneuver: RoutingManeuver)
@Serializable
internal data class RoutingDirectionsRequest(val origin: RoutingPoint, val destination: RoutingPoint)
@Serializable
data class RoutingDirectionsResponse(val directions: List<RoutingDirection>, val distance: Double, val duration: Double, val waypoints: List<RoutingWaypoint>)
@Serializable
internal data class RoutingEtaRequest(val origin: RoutingPoint, val speed: Double, val type: String, val destination: RoutingPoint)
@Serializable
data class RoutingEtaResponse(val duration: Double)
@Serializable
internal data class RoutingIntersection(val location: RoutingPoint, val bearings: List<RoutingDouble>)
@Serializable
internal data class RoutingManeuver(val direction: String, val location: RoutingPoint, val action: String, val bearing_after: Double, val bearing_before: Double)
@Serializable
internal data class RoutingPoint(val latitude: Double, val longitude: Double)
@Serializable
internal data class RoutingRouteRequest(val destination: RoutingPoint, val origin: RoutingPoint)
@Serializable
data class RoutingRouteResponse(val distance: Double, val duration: Double, val waypoints: List<RoutingWaypoint>)
@Serializable
internal data class RoutingWaypoint(val location: RoutingPoint, val name: String)
