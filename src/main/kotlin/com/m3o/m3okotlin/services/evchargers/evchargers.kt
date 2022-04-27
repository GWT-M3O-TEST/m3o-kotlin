
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
internal data class EvchargersAddress()
@Serializable
internal data class EvchargersBoundingBox()
@Serializable
internal data class EvchargersChargerType()
@Serializable
internal data class EvchargersCheckinStatusType()
@Serializable
internal data class EvchargersConnection()
@Serializable
internal data class EvchargersConnectionType()
@Serializable
internal data class EvchargersCoordinates()
@Serializable
internal data class EvchargersCountry()
@Serializable
internal data class EvchargersCurrentType()
@Serializable
internal data class EvchargersDataProvider()
@Serializable
internal data class EvchargersDataProviderStatusType()
@Serializable
internal data class EvchargersOperator()
@Serializable
internal data class EvchargersPoi()
@Serializable
internal data class EvchargersReferenceDataRequest()
@Serializable
data class EvchargersReferenceDataResponse()
@Serializable
internal data class EvchargersSearchRequest()
@Serializable
data class EvchargersSearchResponse()
@Serializable
internal data class EvchargersStatusType()
@Serializable
internal data class EvchargersSubmissionStatusType()
@Serializable
internal data class EvchargersUsageType()
@Serializable
internal data class EvchargersUserCommentType()
