
package com.m3o.m3okotlin.services.holidays

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
data class HolidaysCountriesRequest()
@Serializable
data class HolidaysCountriesResponse(val countries: List<HolidaysCountry>)
@Serializable
data class HolidaysCountry(val code: String, val name: String)
@Serializable
data class HolidaysHoliday(val types: List<HolidaysString>, val country_code: String, val date: String, val local_name: String, val name: String, val regions: List<HolidaysString>)
@Serializable
data class HolidaysListRequest(val country_code: String, val year: Long)
@Serializable
data class HolidaysListResponse(val holidays: List<HolidaysHoliday>)
