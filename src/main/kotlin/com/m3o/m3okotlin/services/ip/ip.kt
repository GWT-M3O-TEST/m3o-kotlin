
package com.m3o.m3okotlin.services.ip

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "ip"

object IpService {
    suspend fun lookup(req: IpLookupRequest): IpLookupResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Lookup")) {
          body = req
        }
    }
}
