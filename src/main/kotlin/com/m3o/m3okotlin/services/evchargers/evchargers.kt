
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
internal data class EvchargersAddress(val address_line_2: String, val lat_lng: String, val location: EvchargersCoordinates, val town: String, val access_comments: String, val country: EvchargersCountry, val country_id: String, val postcode: String, val state_or_province: String, val title: String, val address_line_1: String)
@Serializable
internal data class EvchargersBoundingBox(val bottom_left: EvchargersCoordinates, val top_right: EvchargersCoordinates)
@Serializable
internal data class EvchargersChargerType(val comments: String, val id: String, val is_fast_charge_capable: Boolean, val title: String)
@Serializable
internal data class EvchargersCheckinStatusType(val title: String, val id: String, val is_automated: Boolean, val is_positive: Boolean)
@Serializable
internal data class EvchargersConnection(val voltage: Double, val amps: Double, val connection_type: EvchargersConnectionType, val connection_type_id: String, val level_id: String, val current: String, val level: EvchargersChargerType, val power: Double, val reference: String)
@Serializable
internal data class EvchargersConnectionType(val formal_name: String, val id: String, val is_discontinued: Boolean, val is_obsolete: Boolean, val title: String)
@Serializable
internal data class EvchargersCoordinates(val latitude: Double, val longitude: Double)
@Serializable
internal data class EvchargersCountry(val continent_code: String, val id: String, val iso_code: String, val title: String)
@Serializable
internal data class EvchargersCurrentType(val description: String, val id: String, val title: String)
@Serializable
internal data class EvchargersDataProvider(val id: String, val license: String, val title: String, val website: String, val comments: String, val data_provider_status_type: EvchargersDataProviderStatusType)
@Serializable
internal data class EvchargersDataProviderStatusType(val id: String, val is_provider_enabled: Boolean, val title: String)
@Serializable
internal data class EvchargersOperator(val fault_report_email: String, val is_private_individual: Boolean, val phone_secondary: String, val website: String, val comments: String, val contact_email: String, val id: String, val phone_primary: String, val title: String)
@Serializable
internal data class EvchargersPoi(val connections: List<EvchargersConnection>, val num_points: Long, val operator_id: String, val usage_type: EvchargersUsageType, val usage_type_id: String, val address: EvchargersAddress, val cost: String, val data_provider_id: String, val id: String, val operator: EvchargersOperator)
@Serializable
internal data class EvchargersReferenceDataRequest()
@Serializable
data class EvchargersReferenceDataResponse(val charger_types: List<EvchargersChargerType>, val countries: List<EvchargersCountry>, val operators: List<EvchargersOperator>, val user_comment_types: List<EvchargersUserCommentType>, val usage_types: List<EvchargersUsageType>, val checkin_status_types: List<EvchargersCheckinStatusType>, val connection_types: List<EvchargersConnectionType>, val current_types: List<EvchargersCurrentType>, val data_providers: List<EvchargersDataProvider>, val status_types: List<EvchargersStatusType>, val submission_status_types: List<EvchargersSubmissionStatusType>)
@Serializable
internal data class EvchargersSearchRequest(val country_id: String, val distance: Long, val min_power: Long, val operators: List<EvchargersString>, val usage_types: List<EvchargersString>, val box: EvchargersBoundingBox, val connection_types: List<EvchargersString>, val levels: List<EvchargersString>, val location: EvchargersCoordinates, val max_results: Long)
@Serializable
data class EvchargersSearchResponse(val pois: List<EvchargersPoi>)
@Serializable
internal data class EvchargersStatusType(val id: String, val is_operational: Boolean, val title: String)
@Serializable
internal data class EvchargersSubmissionStatusType(val id: String, val is_live: Boolean, val title: String)
@Serializable
internal data class EvchargersUsageType(val is_access_key_required: Boolean, val is_membership_required: Boolean, val is_pay_at_location: Boolean, val title: String, val id: String)
@Serializable
internal data class EvchargersUserCommentType(val id: String, val title: String)
