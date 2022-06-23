
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
data class EvchargersAddress(val lat_lng: String, val title: String, val address_line_1: String, val address_line_2: String, val country_id: String, val location: EvchargersCoordinates, val postcode: String, val state_or_province: String, val town: String, val access_comments: String, val country: EvchargersCountry)
@Serializable
data class EvchargersBoundingBox(val bottom_left: EvchargersCoordinates, val top_right: EvchargersCoordinates)
@Serializable
data class EvchargersChargerType(val comments: String, val id: String, val is_fast_charge_capable: Boolean, val title: String)
@Serializable
data class EvchargersCheckinStatusType(val is_automated: Boolean, val is_positive: Boolean, val title: String, val id: String)
@Serializable
data class EvchargersConnection(val connection_type: EvchargersConnectionType, val connection_type_id: String, val current: String, val level_id: String, val power: Double, val voltage: Double, val amps: Double, val level: EvchargersChargerType, val reference: String)
@Serializable
data class EvchargersConnectionType(val is_discontinued: Boolean, val is_obsolete: Boolean, val title: String, val formal_name: String, val id: String)
@Serializable
data class EvchargersCoordinates(val latitude: Double, val longitude: Double)
@Serializable
data class EvchargersCountry(val continent_code: String, val id: String, val iso_code: String, val title: String)
@Serializable
data class EvchargersCurrentType(val description: String, val id: String, val title: String)
@Serializable
data class EvchargersDataProvider(val license: String, val title: String, val website: String, val comments: String, val data_provider_status_type: EvchargersDataProviderStatusType, val id: String)
@Serializable
data class EvchargersDataProviderStatusType(val id: String, val is_provider_enabled: Boolean, val title: String)
@Serializable
data class EvchargersOperator(val comments: String, val is_private_individual: Boolean, val phone_primary: String, val title: String, val contact_email: String, val fault_report_email: String, val id: String, val phone_secondary: String, val website: String)
@Serializable
data class EvchargersPoi(val cost: String, val num_points: Long, val operator: EvchargersOperator, val operator_id: String, val usage_type: EvchargersUsageType, val usage_type_id: String, val address: EvchargersAddress, val connections: List<EvchargersConnection>, val data_provider_id: String, val id: String)
@Serializable
data class EvchargersReferenceDataResponse(val usage_types: List<EvchargersUsageType>, val user_comment_types: List<EvchargersUserCommentType>, val charger_types: List<EvchargersChargerType>, val connection_types: List<EvchargersConnectionType>, val countries: List<EvchargersCountry>, val status_types: List<EvchargersStatusType>, val submission_status_types: List<EvchargersSubmissionStatusType>, val checkin_status_types: List<EvchargersCheckinStatusType>, val current_types: List<EvchargersCurrentType>, val data_providers: List<EvchargersDataProvider>, val operators: List<EvchargersOperator>)
@Serializable
data class EvchargersSearchRequest(val levels: List<EvchargersString>, val operators: List<EvchargersString>, val usage_types: List<EvchargersString>, val box: EvchargersBoundingBox, val connection_types: List<EvchargersString>, val country_id: String, val min_power: Long, val distance: Long, val location: EvchargersCoordinates, val max_results: Long)
@Serializable
data class EvchargersSearchResponse(val pois: List<EvchargersPoi>)
@Serializable
data class EvchargersStatusType(val id: String, val is_operational: Boolean, val title: String)
@Serializable
data class EvchargersSubmissionStatusType(val id: String, val is_live: Boolean, val title: String)
@Serializable
data class EvchargersUsageType(val id: String, val is_access_key_required: Boolean, val is_membership_required: Boolean, val is_pay_at_location: Boolean, val title: String)
@Serializable
data class EvchargersUserCommentType(val id: String, val title: String)
