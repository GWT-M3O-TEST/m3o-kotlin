
package com.m3o.m3okotlin.services.ping

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "ping"

object PingService {
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
data class PingIpRequest(val address: String)
@Serializable
data class PingIpResponse(val latency: String, val status: String)
@Serializable
data class PingTcpRequest(val address: String, val data: String)
@Serializable
data class PingTcpResponse(val data: String, val status: String)
@Serializable
data class PingUrlRequest(val address: String, val method: String)
@Serializable
data class PingUrlResponse(val code: Int, val status: String)
