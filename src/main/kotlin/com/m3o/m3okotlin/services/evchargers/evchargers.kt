
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
    suspend fun referenceData(req: EvchargersReferenceDataRequest): EvchargersReferenceDataResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "ReferenceData")) {
          body = req
        }
    }
    suspend fun search(req: EvchargersSearchRequest): EvchargersSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = req
        }
    }
}
@Serializable
data class EvchargersAddress(val access_comments: String, val address_line_2: String, val country_id: String, val location: EvchargersCoordinates, val postcode: String, val state_or_province: String, val title: String, val town: String, val address_line_1: String, val country: EvchargersCountry, val lat_lng: String)
@Serializable
data class EvchargersBoundingBox(val bottom_left: EvchargersCoordinates, val top_right: EvchargersCoordinates)
@Serializable
data class EvchargersChargerType(val is_fast_charge_capable: Boolean, val title: String, val comments: String, val id: String)
@Serializable
data class EvchargersCheckinStatusType(val id: String, val is_automated: Boolean, val is_positive: Boolean, val title: String)
@Serializable
data class EvchargersConnection(val connection_type_id: String, val level: EvchargersChargerType, val level_id: String, val voltage: Double, val amps: Double, val connection_type: EvchargersConnectionType, val current: String, val power: Double, val reference: String)
@Serializable
data class EvchargersConnectionType(val formal_name: String, val id: String, val is_discontinued: Boolean, val is_obsolete: Boolean, val title: String)
@Serializable
data class EvchargersCoordinates(val latitude: Double, val longitude: Double)
@Serializable
data class EvchargersCountry(val title: String, val continent_code: String, val id: String, val iso_code: String)
@Serializable
data class EvchargersCurrentType(val description: String, val id: String, val title: String)
@Serializable
data class EvchargersDataProvider(val data_provider_status_type: EvchargersDataProviderStatusType, val id: String, val license: String, val title: String, val website: String, val comments: String)
@Serializable
data class EvchargersDataProviderStatusType(val id: String, val is_provider_enabled: Boolean, val title: String)
@Serializable
data class EvchargersOperator(val comments: String, val contact_email: String, val is_private_individual: Boolean, val phone_primary: String, val phone_secondary: String, val fault_report_email: String, val id: String, val title: String, val website: String)
@Serializable
data class EvchargersPoi(val usage_type: EvchargersUsageType, val usage_type_id: String, val address: EvchargersAddress, val num_points: Long, val operator: EvchargersOperator, val operator_id: String, val connections: List<EvchargersConnection>, val cost: String, val data_provider_id: String, val id: String)
@Serializable
data class EvchargersReferenceDataRequest()
@Serializable
data class EvchargersReferenceDataResponse(val charger_types: List<EvchargersChargerType>, val checkin_status_types: List<EvchargersCheckinStatusType>, val countries: List<EvchargersCountry>, val operators: List<EvchargersOperator>, val status_types: List<EvchargersStatusType>, val user_comment_types: List<EvchargersUserCommentType>, val connection_types: List<EvchargersConnectionType>, val current_types: List<EvchargersCurrentType>, val data_providers: List<EvchargersDataProvider>, val submission_status_types: List<EvchargersSubmissionStatusType>, val usage_types: List<EvchargersUsageType>)
@Serializable
data class EvchargersSearchRequest(val operators: List<EvchargersString>, val usage_types: List<EvchargersString>, val country_id: String, val distance: Long, val location: EvchargersCoordinates, val max_results: Long, val min_power: Long, val box: EvchargersBoundingBox, val connection_types: List<EvchargersString>, val levels: List<EvchargersString>)
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
