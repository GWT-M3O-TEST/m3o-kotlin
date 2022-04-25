
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
    suspend fun lookup(name: String): VehicleLookupResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Lookup")) {
          body = VehicleLookupRequest(name)
        }
    }
}
@Serializable
internal data class VehicleLookupRequest({/// the vehicle registration number
String? registration,})
@Serializable
data class VehicleLookupResponse({/// engine capacity
int? engine_capacity, /// fuel type e.g petrol, diesel
String? fuel_type, /// wheel plan
String? wheelplan, /// co2 emmissions
double? co2_emissions, /// url of logo for the make
String? logo_url, /// mot expiry
String? mot_expiry, /// date of last v5 issue
String? last_v5_issued, /// tax due data
String? tax_due_date, /// type approvale
String? type_approval, /// year of manufacture
int? year_of_manufacture, /// make of vehicle
String? make, /// month of first registration
String? month_of_first_registration, /// mot status
String? mot_status, /// registration number
String? registration, /// tax status
String? tax_status, /// colour of vehicle
String? colour,})
