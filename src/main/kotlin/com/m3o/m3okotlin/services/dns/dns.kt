
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
internal data class DnsAnswer(val data: String, val name: String, val type: Int, val TTL: Int)
@Serializable
internal data class DnsQueryRequest(val type: String, val name: String)
@Serializable
data class DnsQueryResponse(val RD: Boolean, val answer: List<DnsAnswer>, val provider: String, val AD: Boolean, val RA: Boolean, val TC: Boolean, val question: List<DnsQuestion>, val status: Int, val CD: Boolean)
@Serializable
internal data class DnsQuestion(val name: String, val type: Int)
