
package com.m3o.m3okotlin.services.dns

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
data class DnsAnswer(val type: Int, val TTL: Int, val data: String, val name: String)
@Serializable
data class DnsQueryRequest(val name: String, val type: String)
@Serializable
data class DnsQueryResponse(val AD: Boolean, val CD: Boolean, val question: List<DnsQuestion>, val status: Int, val provider: String, val RA: Boolean, val RD: Boolean, val TC: Boolean, val answer: List<DnsAnswer>)
@Serializable
data class DnsQuestion(val name: String, val type: Int)
