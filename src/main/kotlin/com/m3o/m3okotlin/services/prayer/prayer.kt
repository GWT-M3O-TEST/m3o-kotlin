
package com.m3o.m3okotlin.services.prayer

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "prayer"

object PrayerService {
    suspend fun times(req: PrayerTimesRequest): PrayerTimesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Times")) {
          body = req
        }
    }
}
