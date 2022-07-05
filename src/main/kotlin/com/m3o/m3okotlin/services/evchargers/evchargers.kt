
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
data class EvchargersAddress(val address_line_2: String, val country_id: String, val town: String, val title: String, val access_comments: String, val address_line_1: String, val country: EvchargersCountry, val lat_lng: String, val location: EvchargersCoordinates, val postcode: String, val state_or_province: String)
@Serializable
data class EvchargersBoundingBox(val bottom_left: EvchargersCoordinates, val top_right: EvchargersCoordinates)
@Serializable
data class EvchargersChargerType(val comments: String, val id: String, val is_fast_charge_capable: Boolean, val title: String)
@Serializable
data class EvchargersCheckinStatusType(val id: String, val is_automated: Boolean, val is_positive: Boolean, val title: String)
@Serializable
data class EvchargersConnection(val level: EvchargersChargerType, val voltage: Double, val amps: Double, val connection_type: EvchargersConnectionType, val level_id: String, val power: Double, val reference: String, val connection_type_id: String, val current: String)
@Serializable
data class EvchargersConnectionType(val formal_name: String, val id: String, val is_discontinued: Boolean, val is_obsolete: Boolean, val title: String)
@Serializable
data class EvchargersCoordinates(val latitude: Double, val longitude: Double)
@Serializable
data class EvchargersCountry(val title: String, val continent_code: String, val id: String, val iso_code: String)
@Serializable
data class EvchargersCurrentType(val id: String, val title: String, val description: String)
@Serializable
data class EvchargersDataProvider(val comments: String, val data_provider_status_type: EvchargersDataProviderStatusType, val id: String, val license: String, val title: String, val website: String)
@Serializable
data class EvchargersDataProviderStatusType(val title: String, val id: String, val is_provider_enabled: Boolean)
@Serializable
data class EvchargersOperator(val comments: String, val fault_report_email: String, val phone_primary: String, val phone_secondary: String, val contact_email: String, val id: String, val is_private_individual: Boolean, val title: String, val website: String)
@Serializable
data class EvchargersPoi(val connections: List<EvchargersConnection>, val data_provider_id: String, val usage_type: EvchargersUsageType, val usage_type_id: String, val operator: EvchargersOperator, val operator_id: String, val address: EvchargersAddress, val cost: String, val id: String, val num_points: Long)
@Serializable
data class EvchargersReferenceDataResponse(val checkin_status_types: List<EvchargersCheckinStatusType>, val connection_types: List<EvchargersConnectionType>, val countries: List<EvchargersCountry>, val current_types: List<EvchargersCurrentType>, val operators: List<EvchargersOperator>, val usage_types: List<EvchargersUsageType>, val user_comment_types: List<EvchargersUserCommentType>, val charger_types: List<EvchargersChargerType>, val data_providers: List<EvchargersDataProvider>, val status_types: List<EvchargersStatusType>, val submission_status_types: List<EvchargersSubmissionStatusType>)
@Serializable
data class EvchargersSearchRequest(val connection_types: List<String>, val levels: List<String>, val operators: List<String>, val usage_types: List<String>, val box: EvchargersBoundingBox, val country_id: String, val distance: Long, val location: EvchargersCoordinates, val max_results: Long, val min_power: Long)
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
