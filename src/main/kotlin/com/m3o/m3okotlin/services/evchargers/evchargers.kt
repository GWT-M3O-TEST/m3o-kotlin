
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
internal data class EvchargersAddress(val address_line_1: String, val country: EvchargersCountry, val lat_lng: String, val location: EvchargersCoordinates, val state_or_province: String, val town: String, val access_comments: String, val address_line_2: String, val country_id: String, val postcode: String, val title: String)
@Serializable
internal data class EvchargersBoundingBox(val top_right: EvchargersCoordinates, val bottom_left: EvchargersCoordinates)
@Serializable
internal data class EvchargersChargerType(val title: String, val comments: String, val id: String, val is_fast_charge_capable: Boolean)
@Serializable
internal data class EvchargersCheckinStatusType(val id: String, val is_automated: Boolean, val is_positive: Boolean, val title: String)
@Serializable
internal data class EvchargersConnection(val connection_type: EvchargersConnectionType, val current: String, val level: EvchargersChargerType, val power: Double, val amps: Double, val level_id: String, val reference: String, val voltage: Double, val connection_type_id: String)
@Serializable
internal data class EvchargersConnectionType(val formal_name: String, val id: String, val is_discontinued: Boolean, val is_obsolete: Boolean, val title: String)
@Serializable
internal data class EvchargersCoordinates(val latitude: Double, val longitude: Double)
@Serializable
internal data class EvchargersCountry(val continent_code: String, val id: String, val iso_code: String, val title: String)
@Serializable
internal data class EvchargersCurrentType(val title: String, val description: String, val id: String)
@Serializable
internal data class EvchargersDataProvider(val license: String, val title: String, val website: String, val comments: String, val data_provider_status_type: EvchargersDataProviderStatusType, val id: String)
@Serializable
internal data class EvchargersDataProviderStatusType(val id: String, val is_provider_enabled: Boolean, val title: String)
@Serializable
internal data class EvchargersOperator(val contact_email: String, val is_private_individual: Boolean, val phone_primary: String, val website: String, val comments: String, val fault_report_email: String, val id: String, val phone_secondary: String, val title: String)
@Serializable
internal data class EvchargersPoi(val address: EvchargersAddress, val connections: List<EvchargersConnection>, val cost: String, val id: String, val num_points: Long, val usage_type: EvchargersUsageType, val data_provider_id: String, val operator: EvchargersOperator, val operator_id: String, val usage_type_id: String)
@Serializable
internal data class EvchargersReferenceDataRequest()
@Serializable
data class EvchargersReferenceDataResponse(val status_types: List<EvchargersStatusType>, val submission_status_types: List<EvchargersSubmissionStatusType>, val usage_types: List<EvchargersUsageType>, val user_comment_types: List<EvchargersUserCommentType>, val charger_types: List<EvchargersChargerType>, val checkin_status_types: List<EvchargersCheckinStatusType>, val current_types: List<EvchargersCurrentType>, val data_providers: List<EvchargersDataProvider>, val operators: List<EvchargersOperator>, val connection_types: List<EvchargersConnectionType>, val countries: List<EvchargersCountry>)
@Serializable
internal data class EvchargersSearchRequest(val usage_types: List<EvchargersString>, val box: EvchargersBoundingBox, val connection_types: List<EvchargersString>, val distance: Long, val max_results: Long, val min_power: Long, val operators: List<EvchargersString>, val country_id: String, val levels: List<EvchargersString>, val location: EvchargersCoordinates)
@Serializable
data class EvchargersSearchResponse(val pois: List<EvchargersPoi>)
@Serializable
internal data class EvchargersStatusType(val title: String, val id: String, val is_operational: Boolean)
@Serializable
internal data class EvchargersSubmissionStatusType(val id: String, val is_live: Boolean, val title: String)
@Serializable
internal data class EvchargersUsageType(val id: String, val is_access_key_required: Boolean, val is_membership_required: Boolean, val is_pay_at_location: Boolean, val title: String)
@Serializable
internal data class EvchargersUserCommentType(val title: String, val id: String)
