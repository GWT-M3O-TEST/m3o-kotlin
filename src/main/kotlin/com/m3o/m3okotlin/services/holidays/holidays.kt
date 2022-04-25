
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
data class HolidaysCountriesResponse({List<Country>? countries,})
@Serializable
internal data class HolidaysCountry({/// The 2 letter country code (as defined in ISO 3166-1 alpha-2)
String? code, /// The English name of the country
String? name,})
@Serializable
internal data class HolidaysHoliday({/// the regions within the country that observe this holiday (if not all of them)
List<String>? regions, /// the type of holiday Public, Bank, School, Authorities, Optional, Observance
List<String>? types, /// the country this holiday occurs in
String? country_code, /// date of the holiday in yyyy-mm-dd format
String? date, /// the local name of the holiday
String? local_name, /// the name of the holiday in English
String? name,})
@Serializable
internal data class HolidaysListRequest({/// The 2 letter country code (as defined in ISO 3166-1 alpha-2)
String? country_code, /// The year to list holidays for

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? year
	,})
@Serializable
data class HolidaysListResponse({List<Holiday>? holidays,})
