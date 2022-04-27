
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "holidays"

object HolidaysService {
    suspend fun countries(name: String): HolidaysCountriesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Countries")) {
          body = HolidaysCountriesRequest(name)
        }
    }
    suspend fun list(name: String): HolidaysListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = HolidaysListRequest(name)
        }
    }
}
@Serializable
internal data class HolidaysCountriesRequest()
@Serializable
data class HolidaysCountriesResponse()
@Serializable
internal data class HolidaysCountry()
@Serializable
internal data class HolidaysHoliday()
@Serializable
internal data class HolidaysListRequest()
@Serializable
data class HolidaysListResponse()
