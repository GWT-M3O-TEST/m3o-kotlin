
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
data class DnsAnswer(val TTL: Int, val data: String, val name: String, val type: Int)
@Serializable
data class DnsQueryRequest(val name: String, val type: String)
@Serializable
data class DnsQueryResponse(val status: Int, val CD: Boolean, val TC: Boolean, val provider: String, val answer: List<DnsAnswer>, val question: List<DnsQuestion>, val AD: Boolean, val RA: Boolean, val RD: Boolean)
@Serializable
data class DnsQuestion(val name: String, val type: Int)
