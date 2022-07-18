
package com.m3o.m3okotlin.services.carbon

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "carbon"

object CarbonServ {
      suspend fun offset(): CarbonOffsetResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Offset")) 
      }
}
@Serializable
data class CarbonOffsetResponse(val metric: String? = null, val projects: List<CarbonProject>? = null, val tonnes: Double? = null, val units: Int? = null)
@Serializable
data class CarbonProject(val name: String? = null, val percentage: Double? = null, val tonnes: Double? = null)
