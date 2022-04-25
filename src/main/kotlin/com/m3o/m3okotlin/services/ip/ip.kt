
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "ip"

object IpService {
    suspend fun lookup(name: String): IpLookupResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Lookup")) {
          body = IpLookupRequest(name)
        }
    }
}
@Serializable
internal data class IpLookupRequest({/// IP to lookup
String? ip,})
@Serializable
data class IpLookupResponse({/// Autonomous system number
int? asn, /// Name of the city
String? city, /// Name of the continent
String? continent, /// Name of the country
String? country, /// IP of the query
String? ip, /// Latitude e.g 52.523219
double? latitude, /// Longitude e.g 13.428555
double? longitude, /// Timezone e.g Europe/Rome
String? timezone,})
