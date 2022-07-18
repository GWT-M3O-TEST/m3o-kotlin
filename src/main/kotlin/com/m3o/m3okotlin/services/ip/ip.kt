
package com.m3o.m3okotlin.services.ip

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "ip"

object IpServ {
      suspend fun lookup(req: IpLookupRequest): IpLookupResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Lookup")) {
          body = req
        }
      }
}
@Serializable
data class IpLookupRequest(val ip: String? = null)
@Serializable
data class IpLookupResponse(val country: String? = null, val ip: String? = null, val latitude: Double? = null, val longitude: Double? = null, val timezone: String? = null, val asn: Int? = null, val city: String? = null, val continent: String? = null)
