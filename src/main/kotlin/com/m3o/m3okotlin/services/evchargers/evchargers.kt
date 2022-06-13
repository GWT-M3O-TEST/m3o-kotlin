
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
internal data class EvchargersAddress(val town: String, val address_line_2: String, val lat_lng: String, val location: EvchargersCoordinates, val postcode: String, val state_or_province: String, val title: String, val access_comments: String, val address_line_1: String, val country: EvchargersCountry, val country_id: String)
@Serializable
internal data class EvchargersBoundingBox(val bottom_left: EvchargersCoordinates, val top_right: EvchargersCoordinates)
@Serializable
internal data class EvchargersChargerType(val comments: String, val id: String, val is_fast_charge_capable: Boolean, val title: String)
@Serializable
internal data class EvchargersCheckinStatusType(val is_positive: Boolean, val title: String, val id: String, val is_automated: Boolean)
@Serializable
internal data class EvchargersConnection(val amps: Double, val current: String, val level_id: String, val power: Double, val reference: String, val connection_type: EvchargersConnectionType, val connection_type_id: String, val level: EvchargersChargerType, val voltage: Double)
@Serializable
internal data class EvchargersConnectionType(val formal_name: String, val id: String, val is_discontinued: Boolean, val is_obsolete: Boolean, val title: String)
@Serializable
internal data class EvchargersCoordinates(val latitude: Double, val longitude: Double)
@Serializable
internal data class EvchargersCountry(val continent_code: String, val id: String, val iso_code: String, val title: String)
@Serializable
internal data class EvchargersCurrentType(val id: String, val title: String, val description: String)
@Serializable
internal data class EvchargersDataProvider(val comments: String, val data_provider_status_type: EvchargersDataProviderStatusType, val id: String, val license: String, val title: String, val website: String)
@Serializable
internal data class EvchargersDataProviderStatusType(val id: String, val is_provider_enabled: Boolean, val title: String)
@Serializable
internal data class EvchargersOperator(val phone_secondary: String, val comments: String, val contact_email: String, val id: String, val is_private_individual: Boolean, val phone_primary: String, val fault_report_email: String, val title: String, val website: String)
@Serializable
internal data class EvchargersPoi(val address: EvchargersAddress, val connections: List<EvchargersConnection>, val cost: String, val id: String, val operator: EvchargersOperator, val data_provider_id: String, val num_points: Long, val operator_id: String, val usage_type: EvchargersUsageType, val usage_type_id: String)
@Serializable
internal data class EvchargersReferenceDataRequest()
@Serializable
data class EvchargersReferenceDataResponse(val connection_types: List<EvchargersConnectionType>, val status_types: List<EvchargersStatusType>, val submission_status_types: List<EvchargersSubmissionStatusType>, val usage_types: List<EvchargersUsageType>, val user_comment_types: List<EvchargersUserCommentType>, val checkin_status_types: List<EvchargersCheckinStatusType>, val countries: List<EvchargersCountry>, val current_types: List<EvchargersCurrentType>, val data_providers: List<EvchargersDataProvider>, val operators: List<EvchargersOperator>, val charger_types: List<EvchargersChargerType>)
@Serializable
internal data class EvchargersSearchRequest(val operators: List<EvchargersString>, val usage_types: List<EvchargersString>, val connection_types: List<EvchargersString>, val country_id: String, val min_power: Long, val location: EvchargersCoordinates, val max_results: Long, val box: EvchargersBoundingBox, val distance: Long, val levels: List<EvchargersString>)
@Serializable
data class EvchargersSearchResponse(val pois: List<EvchargersPoi>)
@Serializable
internal data class EvchargersStatusType(val title: String, val id: String, val is_operational: Boolean)
@Serializable
internal data class EvchargersSubmissionStatusType(val id: String, val is_live: Boolean, val title: String)
@Serializable
internal data class EvchargersUsageType(val is_membership_required: Boolean, val is_pay_at_location: Boolean, val title: String, val id: String, val is_access_key_required: Boolean)
@Serializable
internal data class EvchargersUserCommentType(val id: String, val title: String)
