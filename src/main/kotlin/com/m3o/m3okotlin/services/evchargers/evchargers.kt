
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "evchargers"

object EvchargersService {
    suspend fun referenceData(name: String): EvchargersReferenceDataResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "ReferenceData")) {
          body = EvchargersReferenceDataRequest(name)
        }
    }
    suspend fun search(name: String): EvchargersSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = EvchargersSearchRequest(name)
        }
    }
}
@Serializable
internal data class EvchargersAddress(val address_line_2: String, val country_id: String, val state_or_province: String, val town: String, val address_line_1: String, val country: EvchargersCountry, val lat_lng: String, val location: EvchargersCoordinates, val postcode: String, val title: String, val access_comments: String)
@Serializable
internal data class EvchargersBoundingBox(val bottom_left: EvchargersCoordinates, val top_right: EvchargersCoordinates)
@Serializable
internal data class EvchargersChargerType(val comments: String, val id: String, val is_fast_charge_capable: Boolean, val title: String)
@Serializable
internal data class EvchargersCheckinStatusType(val title: String, val id: String, val is_automated: Boolean, val is_positive: Boolean)
@Serializable
internal data class EvchargersConnection(val amps: Double, val connection_type: EvchargersConnectionType, val power: Double, val reference: String, val voltage: Double, val connection_type_id: String, val current: String, val level: EvchargersChargerType, val level_id: String)
@Serializable
internal data class EvchargersConnectionType(val is_obsolete: Boolean, val title: String, val formal_name: String, val id: String, val is_discontinued: Boolean)
@Serializable
internal data class EvchargersCoordinates(val latitude: Double, val longitude: Double)
@Serializable
internal data class EvchargersCountry(val continent_code: String, val id: String, val iso_code: String, val title: String)
@Serializable
internal data class EvchargersCurrentType(val id: String, val title: String, val description: String)
@Serializable
internal data class EvchargersDataProvider(val id: String, val license: String, val title: String, val website: String, val comments: String, val data_provider_status_type: EvchargersDataProviderStatusType)
@Serializable
internal data class EvchargersDataProviderStatusType(val is_provider_enabled: Boolean, val title: String, val id: String)
@Serializable
internal data class EvchargersOperator(val is_private_individual: Boolean, val phone_secondary: String, val title: String, val website: String, val contact_email: String, val fault_report_email: String, val id: String, val comments: String, val phone_primary: String)
@Serializable
internal data class EvchargersPoi(val operator_id: String, val usage_type: EvchargersUsageType, val usage_type_id: String, val address: EvchargersAddress, val data_provider_id: String, val id: String, val num_points: Long, val operator: EvchargersOperator, val connections: List<EvchargersConnection>, val cost: String)
@Serializable
internal data class EvchargersReferenceDataRequest()
@Serializable
data class EvchargersReferenceDataResponse(val data_providers: List<EvchargersDataProvider>, val status_types: List<EvchargersStatusType>, val submission_status_types: List<EvchargersSubmissionStatusType>, val user_comment_types: List<EvchargersUserCommentType>, val charger_types: List<EvchargersChargerType>, val checkin_status_types: List<EvchargersCheckinStatusType>, val connection_types: List<EvchargersConnectionType>, val countries: List<EvchargersCountry>, val current_types: List<EvchargersCurrentType>, val operators: List<EvchargersOperator>, val usage_types: List<EvchargersUsageType>)
@Serializable
internal data class EvchargersSearchRequest(val connection_types: List<EvchargersString>, val country_id: String, val levels: List<EvchargersString>, val max_results: Long, val usage_types: List<EvchargersString>, val box: EvchargersBoundingBox, val distance: Long, val location: EvchargersCoordinates, val min_power: Long, val operators: List<EvchargersString>)
@Serializable
data class EvchargersSearchResponse(val pois: List<EvchargersPoi>)
@Serializable
internal data class EvchargersStatusType(val id: String, val is_operational: Boolean, val title: String)
@Serializable
internal data class EvchargersSubmissionStatusType(val id: String, val is_live: Boolean, val title: String)
@Serializable
internal data class EvchargersUsageType(val title: String, val id: String, val is_access_key_required: Boolean, val is_membership_required: Boolean, val is_pay_at_location: Boolean)
@Serializable
internal data class EvchargersUserCommentType(val id: String, val title: String)
