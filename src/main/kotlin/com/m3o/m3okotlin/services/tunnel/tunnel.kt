
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "tunnel"

object TunnelService {
    suspend fun send(name: String): TunnelSendResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Send")) {
          body = TunnelSendRequest(name)
        }
    }
}
@Serializable
internal data class TunnelSendRequest({/// alternatively specify a full url e.g https://www.google.com/news
String? url, /// body of the request
String? body, /// headers to include e.g Content-Type: application/json
Map<String, String>? headers, /// host to send to e.g www.google.com
String? host, /// method of the request e.g GET, POST, DELETE
String? method, /// request params to include
Map<String, String>? params, /// path to request e.g /news
String? path,})
@Serializable
data class TunnelSendResponse({/// body of the response
String? body, /// headers included
Map<String, String>? headers, /// the status
String? status, /// the status code
int? status_code,})
