
package com.m3o.m3okotlin.services.vehicle

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

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
data class VehicleLookupResponse(val last_v5_issued: String, val logo_url: String, val tax_due_date: String, val tax_status: String, val fuel_type: String, val make: String, val mot_status: String, val type_approval: String, val wheelplan: String, val year_of_manufacture: Int, val engine_capacity: Int, val mot_expiry: String, val registration: String, val co2_emissions: Double, val colour: String, val month_of_first_registration: String)
