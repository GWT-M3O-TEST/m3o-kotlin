
package com.m3o.m3okotlin.services.ping

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "ping"

object PingServ {
      suspend fun ip(req: PingIpRequest): PingIpResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Ip")) {
          body = req
        }
      }
      suspend fun tcp(req: PingTcpRequest): PingTcpResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Tcp")) {
          body = req
        }
      }
      suspend fun url(req: PingUrlRequest): PingUrlResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Url")) {
          body = req
        }
      }
}
@Serializable
data class PingIpRequest(val address: String? = null)
@Serializable
data class PingIpResponse(val latency: String? = null, val status: String? = null)
@Serializable
data class PingTcpRequest(val address: String? = null, val data: String? = null)
@Serializable
data class PingTcpResponse(val data: String? = null, val status: String? = null)
@Serializable
data class PingUrlRequest(val address: String? = null, val method: String? = null)
@Serializable
data class PingUrlResponse(val code: Int? = null, val status: String? = null)
