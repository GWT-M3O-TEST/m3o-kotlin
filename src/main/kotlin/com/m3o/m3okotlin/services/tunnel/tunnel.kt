
package com.m3o.m3okotlin.services.tunnel

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "tunnel"

object TunnelServ {
      suspend fun send(req: TunnelSendRequest): TunnelSendResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Send")) {
          body = req
        }
      }
}
@Serializable
data class TunnelSendRequest(val body: String? = null, val headers: Map<String, String>? = null, val host: String? = null, val method: String? = null, val params: Map<String, String>? = null, val path: String? = null, val url: String? = null)
@Serializable
data class TunnelSendResponse(val status_code: Int? = null, val body: String? = null, val headers: Map<String, String>? = null, val status: String? = null)
