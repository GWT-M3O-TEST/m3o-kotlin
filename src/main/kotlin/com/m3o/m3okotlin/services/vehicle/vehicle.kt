
package com.m3o.m3okotlin.services

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
internal data class VehicleLookupRequest(val registration: String)
@Serializable
data class VehicleLookupResponse(val co2_emissions: Double, val last_v5_issued: String, val month_of_first_registration: String, val wheelplan: String, val tax_due_date: String, val colour: String, val engine_capacity: Int, val fuel_type: String, val logo_url: String, val make: String, val mot_expiry: String, val registration: String, val year_of_manufacture: Int, val mot_status: String, val tax_status: String, val type_approval: String)
