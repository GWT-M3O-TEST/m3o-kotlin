
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
internal data class PingIpRequest({/// address to ping
String? address,})
@Serializable
data class PingIpResponse({/// response status
String? status, /// average latency e.g 10ms
String? latency,})
@Serializable
internal data class PingTcpRequest({/// address to dial
String? address, /// optional data to send
String? data,})
@Serializable
data class PingTcpResponse({/// response data if any
String? data, /// response status
String? status,})
@Serializable
internal data class PingUrlRequest({/// address to use
String? address, /// method of the call
String? method,})
@Serializable
data class PingUrlResponse({/// the response code
int? code, /// the response status
String? status,})
