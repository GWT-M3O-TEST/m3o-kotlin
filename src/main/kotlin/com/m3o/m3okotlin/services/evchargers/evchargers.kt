
package com.m3o.m3okotlin.services.evchargers

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

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
data class EvchargersAddress(val title: String, val town: String, val access_comments: String, val address_line_1: String, val address_line_2: String, val country: EvchargersCountry, val country_id: String, val lat_lng: String, val location: EvchargersCoordinates, val postcode: String, val state_or_province: String)
@Serializable
data class EvchargersBoundingBox(val bottom_left: EvchargersCoordinates, val top_right: EvchargersCoordinates)
@Serializable
data class EvchargersChargerType(val title: String, val comments: String, val id: String, val is_fast_charge_capable: Boolean)
@Serializable
data class EvchargersCheckinStatusType(val id: String, val is_automated: Boolean, val is_positive: Boolean, val title: String)
@Serializable
data class EvchargersConnection(val voltage: Double, val amps: Double, val current: String, val level: EvchargersChargerType, val level_id: String, val power: Double, val reference: String, val connection_type: EvchargersConnectionType, val connection_type_id: String)
@Serializable
data class EvchargersConnectionType(val formal_name: String, val id: String, val is_discontinued: Boolean, val is_obsolete: Boolean, val title: String)
@Serializable
data class EvchargersCoordinates(val latitude: Double, val longitude: Double)
@Serializable
data class EvchargersCountry(val continent_code: String, val id: String, val iso_code: String, val title: String)
@Serializable
data class EvchargersCurrentType(val title: String, val description: String, val id: String)
@Serializable
data class EvchargersDataProvider(val id: String, val license: String, val title: String, val website: String, val comments: String, val data_provider_status_type: EvchargersDataProviderStatusType)
@Serializable
data class EvchargersDataProviderStatusType(val id: String, val is_provider_enabled: Boolean, val title: String)
@Serializable
data class EvchargersOperator(val fault_report_email: String, val is_private_individual: Boolean, val phone_secondary: String, val title: String, val website: String, val comments: String, val contact_email: String, val id: String, val phone_primary: String)
@Serializable
data class EvchargersPoi(val cost: String, val data_provider_id: String, val id: String, val operator: EvchargersOperator, val operator_id: String, val usage_type_id: String, val address: EvchargersAddress, val connections: List<EvchargersConnection>, val num_points: Long, val usage_type: EvchargersUsageType)
@Serializable
data class EvchargersReferenceDataResponse(val charger_types: List<EvchargersChargerType>, val countries: List<EvchargersCountry>, val data_providers: List<EvchargersDataProvider>, val status_types: List<EvchargersStatusType>, val usage_types: List<EvchargersUsageType>, val user_comment_types: List<EvchargersUserCommentType>, val checkin_status_types: List<EvchargersCheckinStatusType>, val connection_types: List<EvchargersConnectionType>, val current_types: List<EvchargersCurrentType>, val operators: List<EvchargersOperator>, val submission_status_types: List<EvchargersSubmissionStatusType>)
@Serializable
data class EvchargersSearchRequest(val box: EvchargersBoundingBox, val max_results: Long, val min_power: Long, val operators: List<String>, val usage_types: List<String>, val connection_types: List<String>, val country_id: String, val distance: Long, val levels: List<String>, val location: EvchargersCoordinates)
@Serializable
data class EvchargersSearchResponse(val pois: List<EvchargersPoi>)
@Serializable
data class EvchargersStatusType(val id: String, val is_operational: Boolean, val title: String)
@Serializable
data class EvchargersSubmissionStatusType(val title: String, val id: String, val is_live: Boolean)
@Serializable
data class EvchargersUsageType(val id: String, val is_access_key_required: Boolean, val is_membership_required: Boolean, val is_pay_at_location: Boolean, val title: String)
@Serializable
data class EvchargersUserCommentType(val id: String, val title: String)
