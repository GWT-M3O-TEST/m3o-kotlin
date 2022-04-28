
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
internal data class DnsAnswer(val TTL: Int, val data: String, val name: String, val type: Int)
@Serializable
internal data class DnsQueryRequest(val name: String, val type: String)
@Serializable
data class DnsQueryResponse(val CD: Boolean, val answer: List<DnsAnswer>, val provider: String, val question: List<DnsQuestion>, val AD: Boolean, val RD: Boolean, val TC: Boolean, val status: Int, val RA: Boolean)
@Serializable
internal data class DnsQuestion(val name: String, val type: Int)
