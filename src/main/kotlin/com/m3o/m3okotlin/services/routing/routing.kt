
package com.m3o.m3okotlin.services.routing

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "routing"

object RoutingServ {
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
data class RoutingDirection(val instruction: String? = null, val intersections: List<RoutingIntersection>? = null, val maneuver: RoutingManeuver? = null, val name: String? = null, val reference: String? = null, val distance: Double? = null, val duration: Double? = null)
@Serializable
data class RoutingDirectionsRequest(val destination: RoutingPoint? = null, val origin: RoutingPoint? = null)
@Serializable
data class RoutingDirectionsResponse(val waypoints: List<RoutingWaypoint>? = null, val directions: List<RoutingDirection>? = null, val distance: Double? = null, val duration: Double? = null)
@Serializable
data class RoutingEtaRequest(val destination: RoutingPoint? = null, val origin: RoutingPoint? = null, val speed: Double? = null, val type: String? = null)
@Serializable
data class RoutingEtaResponse(val duration: Double? = null)
@Serializable
data class RoutingIntersection(val bearings: List<Double>? = null, val location: RoutingPoint? = null)
@Serializable
data class RoutingManeuver(val action: String? = null, val bearing_after: Double? = null, val bearing_before: Double? = null, val direction: String? = null, val location: RoutingPoint? = null)
@Serializable
data class RoutingPoint(val latitude: Double? = null, val longitude: Double? = null)
@Serializable
data class RoutingRouteRequest(val origin: RoutingPoint? = null, val destination: RoutingPoint? = null)
@Serializable
data class RoutingRouteResponse(val distance: Double? = null, val duration: Double? = null, val waypoints: List<RoutingWaypoint>? = null)
@Serializable
data class RoutingWaypoint(val name: String? = null, val location: RoutingPoint? = null)
