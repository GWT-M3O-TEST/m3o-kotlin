
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
internal data class RoutingDirection()
@Serializable
internal data class RoutingDirectionsRequest()
@Serializable
data class RoutingDirectionsResponse()
@Serializable
internal data class RoutingEtaRequest()
@Serializable
data class RoutingEtaResponse()
@Serializable
internal data class RoutingIntersection()
@Serializable
internal data class RoutingManeuver()
@Serializable
internal data class RoutingPoint()
@Serializable
internal data class RoutingRouteRequest()
@Serializable
data class RoutingRouteResponse()
@Serializable
internal data class RoutingWaypoint()
