
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "ping"

object PingService {
    suspend fun ip(name: String): PingIpResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Ip")) {
          body = PingIpRequest(name)
        }
    }
    suspend fun tcp(name: String): PingTcpResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Tcp")) {
          body = PingTcpRequest(name)
        }
    }
    suspend fun url(name: String): PingUrlResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Url")) {
          body = PingUrlRequest(name)
        }
    }
}
@Serializable
internal data class PingIpRequest()
@Serializable
data class PingIpResponse()
@Serializable
internal data class PingTcpRequest()
@Serializable
data class PingTcpResponse()
@Serializable
internal data class PingUrlRequest()
@Serializable
data class PingUrlResponse()
