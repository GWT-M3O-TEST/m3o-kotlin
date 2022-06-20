
package com.m3o.m3okotlin.services.tunnel

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "tunnel"

object TunnelService {
    suspend fun send(req: TunnelSendRequest): TunnelSendResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Send")) {
          body = req
        }
    }
}
@Serializable
data class TunnelSendRequest(val method: String, val params: Map<String, String>, val path: String, val url: String, val body: String, val headers: Map<String, String>, val host: String)
@Serializable
data class TunnelSendResponse(val body: String, val headers: Map<String, String>, val status: String, val status_code: Int)
