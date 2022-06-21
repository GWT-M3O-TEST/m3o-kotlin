
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
    suspend fun countries(): HolidaysCountriesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Countries")) 
    }
}
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
    suspend fun list(req: HolidaysListRequest): HolidaysListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = req
        }
    }
}
