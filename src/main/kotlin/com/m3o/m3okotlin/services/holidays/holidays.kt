
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
    suspend fun countries(req: HolidaysCountriesRequest): HolidaysCountriesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Countries")) {
          body = req
        }
    }
    suspend fun list(req: HolidaysListRequest): HolidaysListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = req
        }
    }
}
@Serializable
internal data class HolidaysCountriesRequest()
@Serializable
data class HolidaysCountriesResponse(val countries: List<HolidaysCountry>)
@Serializable
internal data class HolidaysCountry(val code: String, val name: String)
@Serializable
internal data class HolidaysHoliday(val date: String, val local_name: String, val name: String, val regions: List<HolidaysString>, val types: List<HolidaysString>, val country_code: String)
@Serializable
internal data class HolidaysListRequest(val country_code: String, val year: Long)
@Serializable
data class HolidaysListResponse(val holidays: List<HolidaysHoliday>)
