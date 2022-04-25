
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
data class VehicleLookupResponse({/// month of first registration
String? month_of_first_registration, /// tax status
String? tax_status, /// wheel plan
String? wheelplan, /// co2 emmissions
double? co2_emissions, /// fuel type e.g petrol, diesel
String? fuel_type, /// mot expiry
String? mot_expiry, /// mot status
String? mot_status, /// type approvale
String? type_approval, /// year of manufacture
int? year_of_manufacture, /// date of last v5 issue
String? last_v5_issued, /// url of logo for the make
String? logo_url, /// make of vehicle
String? make, /// tax due data
String? tax_due_date, /// colour of vehicle
String? colour, /// engine capacity
int? engine_capacity, /// registration number
String? registration,})
