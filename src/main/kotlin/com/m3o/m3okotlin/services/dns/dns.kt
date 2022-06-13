
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
    suspend fun query(req: DnsQueryRequest): DnsQueryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Query")) {
          body = req
        }
    }
}
@Serializable
internal data class DnsAnswer(val TTL: Int, val data: String, val name: String, val type: Int)
@Serializable
internal data class DnsQueryRequest(val name: String, val type: String)
@Serializable
data class DnsQueryResponse(val AD: Boolean, val CD: Boolean, val RD: Boolean, val answer: List<DnsAnswer>, val provider: String, val question: List<DnsQuestion>, val status: Int, val RA: Boolean, val TC: Boolean)
@Serializable
internal data class DnsQuestion(val name: String, val type: Int)
