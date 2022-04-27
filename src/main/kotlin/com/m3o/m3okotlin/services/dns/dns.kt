
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "dns"

object DnsService {
    suspend fun query(name: String): DnsQueryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Query")) {
          body = DnsQueryRequest(name)
        }
    }
}
@Serializable
internal data class DnsAnswer()
@Serializable
internal data class DnsQueryRequest()
@Serializable
data class DnsQueryResponse()
@Serializable
internal data class DnsQuestion()
