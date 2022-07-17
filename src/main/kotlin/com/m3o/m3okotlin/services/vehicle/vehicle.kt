
package com.m3o.m3okotlin.services.vehicle

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "vehicle"

object VehicleServ {
      suspend fun lookup(req: VehicleLookupRequest): VehicleLookupResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Lookup")) {
          body = req
        }
      }
}
@Serializable
data class VehicleLookupRequest(val registration: String)
@Serializable
data class VehicleLookupResponse(val registration: String, val tax_status: String, val wheelplan: String, val fuel_type: String, val make: String, val co2_emissions: Double, val last_v5_issued: String, val logo_url: String, val month_of_first_registration: String, val mot_expiry: String, val mot_status: String, val tax_due_date: String, val colour: String, val engine_capacity: Int, val type_approval: String, val year_of_manufacture: Int)
