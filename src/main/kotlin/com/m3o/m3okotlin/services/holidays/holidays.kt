
package com.m3o.m3okotlin.services.holidays

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "holidays"

object HolidaysServ {
      suspend fun countries(): HolidaysCountriesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Countries")) 
      }
      suspend fun list(req: HolidaysListRequest): HolidaysListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = req
        }
      }
}
@Serializable
data class HolidaysCountriesResponse(val countries: List<HolidaysCountry>? = null)
@Serializable
data class HolidaysCountry(val code: String? = null, val name: String? = null)
@Serializable
data class HolidaysHoliday(val country_code: String? = null, val date: String? = null, val local_name: String? = null, val name: String? = null, val regions: List<String>? = null, val types: List<String>? = null)
@Serializable
data class HolidaysListRequest(val country_code: String? = null, val year: Long? = null)
@Serializable
data class HolidaysListResponse(val holidays: List<HolidaysHoliday>? = null)
