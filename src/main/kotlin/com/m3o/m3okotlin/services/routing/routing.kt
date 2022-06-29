
package com.m3o.m3okotlin.services.routing

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
data class RoutingDirection(val name: String, val reference: String, val distance: Double, val duration: Double, val instruction: String, val intersections: List<RoutingIntersection>, val maneuver: RoutingManeuver)
@Serializable
data class RoutingDirectionsRequest(val destination: RoutingPoint, val origin: RoutingPoint)
@Serializable
data class RoutingDirectionsResponse(val duration: Double, val waypoints: List<RoutingWaypoint>, val directions: List<RoutingDirection>, val distance: Double)
@Serializable
data class RoutingEtaRequest(val type: String, val destination: RoutingPoint, val origin: RoutingPoint, val speed: Double)
@Serializable
data class RoutingEtaResponse(val duration: Double)
@Serializable
data class RoutingIntersection(val location: RoutingPoint, val bearings: List<Double>)
@Serializable
data class RoutingManeuver(val bearing_after: Double, val bearing_before: Double, val direction: String, val location: RoutingPoint, val action: String)
@Serializable
data class RoutingPoint(val latitude: Double, val longitude: Double)
@Serializable
data class RoutingRouteRequest(val destination: RoutingPoint, val origin: RoutingPoint)
@Serializable
data class RoutingRouteResponse(val duration: Double, val waypoints: List<RoutingWaypoint>, val distance: Double)
@Serializable
data class RoutingWaypoint(val location: RoutingPoint, val name: String)
