
package com.m3o.m3okotlin.services.evchargers

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "evchargers"

object EvchargersService {
      suspend fun referenceData(): EvchargersReferenceDataResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "ReferenceData")) 
      }
      suspend fun search(req: EvchargersSearchRequest): EvchargersSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = req
        }
      }
}
@Serializable
data class EvchargersAddress(val country_id: String, val lat_lng: String, val location: EvchargersCoordinates, val postcode: String, val access_comments: String, val address_line_1: String, val address_line_2: String, val country: EvchargersCountry, val title: String, val state_or_province: String, val town: String)
@Serializable
data class EvchargersBoundingBox(val bottom_left: EvchargersCoordinates, val top_right: EvchargersCoordinates)
@Serializable
data class EvchargersChargerType(val title: String, val comments: String, val id: String, val is_fast_charge_capable: Boolean)
@Serializable
data class EvchargersCheckinStatusType(val is_positive: Boolean, val title: String, val id: String, val is_automated: Boolean)
@Serializable
data class EvchargersConnection(val current: String, val level: EvchargersChargerType, val reference: String, val amps: Double, val connection_type: EvchargersConnectionType, val connection_type_id: String, val level_id: String, val power: Double, val voltage: Double)
@Serializable
data class EvchargersConnectionType(val id: String, val is_discontinued: Boolean, val is_obsolete: Boolean, val title: String, val formal_name: String)
@Serializable
data class EvchargersCoordinates(val longitude: Double, val latitude: Double)
@Serializable
data class EvchargersCountry(val id: String, val iso_code: String, val title: String, val continent_code: String)
@Serializable
data class EvchargersCurrentType(val id: String, val title: String, val description: String)
@Serializable
data class EvchargersDataProvider(val website: String, val comments: String, val data_provider_status_type: EvchargersDataProviderStatusType, val id: String, val license: String, val title: String)
@Serializable
data class EvchargersDataProviderStatusType(val id: String, val is_provider_enabled: Boolean, val title: String)
@Serializable
data class EvchargersOperator(val phone_secondary: String, val title: String, val website: String, val contact_email: String, val id: String, val is_private_individual: Boolean, val phone_primary: String, val comments: String, val fault_report_email: String)
@Serializable
data class EvchargersPoi(val connections: List<EvchargersConnection>, val cost: String, val data_provider_id: String, val usage_type: EvchargersUsageType, val address: EvchargersAddress, val id: String, val num_points: Long, val operator: EvchargersOperator, val operator_id: String, val usage_type_id: String)
@Serializable
data class EvchargersReferenceDataResponse(val current_types: List<EvchargersCurrentType>, val data_providers: List<EvchargersDataProvider>, val operators: List<EvchargersOperator>, val status_types: List<EvchargersStatusType>, val submission_status_types: List<EvchargersSubmissionStatusType>, val charger_types: List<EvchargersChargerType>, val checkin_status_types: List<EvchargersCheckinStatusType>, val connection_types: List<EvchargersConnectionType>, val countries: List<EvchargersCountry>, val usage_types: List<EvchargersUsageType>, val user_comment_types: List<EvchargersUserCommentType>)
@Serializable
data class EvchargersSearchRequest(val connection_types: List<String>, val levels: List<String>, val operators: List<String>, val usage_types: List<String>, val box: EvchargersBoundingBox, val country_id: String, val distance: Long, val location: EvchargersCoordinates, val max_results: Long, val min_power: Long)
@Serializable
data class EvchargersSearchResponse(val pois: List<EvchargersPoi>)
@Serializable
data class EvchargersStatusType(val id: String, val is_operational: Boolean, val title: String)
@Serializable
data class EvchargersSubmissionStatusType(val id: String, val is_live: Boolean, val title: String)
@Serializable
data class EvchargersUsageType(val is_membership_required: Boolean, val is_pay_at_location: Boolean, val title: String, val id: String, val is_access_key_required: Boolean)
@Serializable
data class EvchargersUserCommentType(val id: String, val title: String)
