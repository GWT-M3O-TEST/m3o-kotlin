
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

object EvchargersServ {
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
data class EvchargersAddress(val country: EvchargersCountry? = null, val lat_lng: String? = null, val location: EvchargersCoordinates? = null, val postcode: String? = null, val state_or_province: String? = null, val title: String? = null, val town: String? = null, val access_comments: String? = null, val address_line_1: String? = null, val address_line_2: String? = null, val country_id: String? = null)
@Serializable
data class EvchargersBoundingBox(val bottom_left: EvchargersCoordinates? = null, val top_right: EvchargersCoordinates? = null)
@Serializable
data class EvchargersChargerType(val comments: String? = null, val id: String? = null, val is_fast_charge_capable: Boolean? = null, val title: String? = null)
@Serializable
data class EvchargersCheckinStatusType(val id: String? = null, val is_automated: Boolean? = null, val is_positive: Boolean? = null, val title: String? = null)
@Serializable
data class EvchargersConnection(val connection_type: EvchargersConnectionType? = null, val level: EvchargersChargerType? = null, val level_id: String? = null, val voltage: Double? = null, val amps: Double? = null, val connection_type_id: String? = null, val current: String? = null, val power: Double? = null, val reference: String? = null)
@Serializable
data class EvchargersConnectionType(val formal_name: String? = null, val id: String? = null, val is_discontinued: Boolean? = null, val is_obsolete: Boolean? = null, val title: String? = null)
@Serializable
data class EvchargersCoordinates(val latitude: Double? = null, val longitude: Double? = null)
@Serializable
data class EvchargersCountry(val id: String? = null, val iso_code: String? = null, val title: String? = null, val continent_code: String? = null)
@Serializable
data class EvchargersCurrentType(val description: String? = null, val id: String? = null, val title: String? = null)
@Serializable
data class EvchargersDataProvider(val website: String? = null, val comments: String? = null, val data_provider_status_type: EvchargersDataProviderStatusType? = null, val id: String? = null, val license: String? = null, val title: String? = null)
@Serializable
data class EvchargersDataProviderStatusType(val id: String? = null, val is_provider_enabled: Boolean? = null, val title: String? = null)
@Serializable
data class EvchargersOperator(val comments: String? = null, val fault_report_email: String? = null, val id: String? = null, val contact_email: String? = null, val is_private_individual: Boolean? = null, val phone_primary: String? = null, val phone_secondary: String? = null, val title: String? = null, val website: String? = null)
@Serializable
data class EvchargersPoi(val address: EvchargersAddress? = null, val operator_id: String? = null, val usage_type: EvchargersUsageType? = null, val usage_type_id: String? = null, val connections: List<EvchargersConnection>? = null, val cost: String? = null, val data_provider_id: String? = null, val id: String? = null, val num_points: Long? = null, val operator: EvchargersOperator? = null)
@Serializable
data class EvchargersReferenceDataResponse(val charger_types: List<EvchargersChargerType>? = null, val current_types: List<EvchargersCurrentType>? = null, val data_providers: List<EvchargersDataProvider>? = null, val operators: List<EvchargersOperator>? = null, val status_types: List<EvchargersStatusType>? = null, val submission_status_types: List<EvchargersSubmissionStatusType>? = null, val usage_types: List<EvchargersUsageType>? = null, val checkin_status_types: List<EvchargersCheckinStatusType>? = null, val connection_types: List<EvchargersConnectionType>? = null, val countries: List<EvchargersCountry>? = null, val user_comment_types: List<EvchargersUserCommentType>? = null)
@Serializable
data class EvchargersSearchRequest(val operators: List<String>? = null, val usage_types: List<String>? = null, val box: EvchargersBoundingBox? = null, val distance: Long? = null, val location: EvchargersCoordinates? = null, val max_results: Long? = null, val min_power: Long? = null, val connection_types: List<String>? = null, val country_id: String? = null, val levels: List<String>? = null)
@Serializable
data class EvchargersSearchResponse(val pois: List<EvchargersPoi>? = null)
@Serializable
data class EvchargersStatusType(val id: String? = null, val is_operational: Boolean? = null, val title: String? = null)
@Serializable
data class EvchargersSubmissionStatusType(val id: String? = null, val is_live: Boolean? = null, val title: String? = null)
@Serializable
data class EvchargersUsageType(val is_pay_at_location: Boolean? = null, val title: String? = null, val id: String? = null, val is_access_key_required: Boolean? = null, val is_membership_required: Boolean? = null)
@Serializable
data class EvchargersUserCommentType(val id: String? = null, val title: String? = null)
