
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
data class VehicleLookupResponse(val month_of_first_registration: String, val mot_expiry: String, val registration: String, val type_approval: String, val engine_capacity: Int, val last_v5_issued: String, val make: String, val tax_status: String, val wheelplan: String, val year_of_manufacture: Int, val colour: String, val fuel_type: String, val mot_status: String, val tax_due_date: String, val co2_emissions: Double, val logo_url: String)
