
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

object VehicleService {
      suspend fun lookup(req: VehicleLookupRequest): VehicleLookupResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Lookup")) {
          body = req
        }
      }
}
@Serializable
data class VehicleLookupRequest(val registration: String)
@Serializable
data class VehicleLookupResponse(val fuel_type: String, val month_of_first_registration: String, val mot_status: String, val registration: String, val type_approval: String, val colour: String, val tax_due_date: String, val tax_status: String, val year_of_manufacture: Int, val make: String, val engine_capacity: Int, val logo_url: String, val mot_expiry: String, val wheelplan: String, val co2_emissions: Double, val last_v5_issued: String)
