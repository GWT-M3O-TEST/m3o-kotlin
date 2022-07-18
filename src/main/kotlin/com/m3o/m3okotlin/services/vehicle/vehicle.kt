
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
data class VehicleLookupRequest(val registration: String? = null)
@Serializable
data class VehicleLookupResponse(val engine_capacity: Int? = null, val fuel_type: String? = null, val last_v5_issued: String? = null, val logo_url: String? = null, val tax_due_date: String? = null, val wheelplan: String? = null, val co2_emissions: Double? = null, val colour: String? = null, val make: String? = null, val month_of_first_registration: String? = null, val mot_expiry: String? = null, val mot_status: String? = null, val year_of_manufacture: Int? = null, val registration: String? = null, val type_approval: String? = null, val tax_status: String? = null)
