
package com.m3o.m3okotlin.services.dns

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "dns"

object DnsService {
      suspend fun query(req: DnsQueryRequest): DnsQueryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Query")) {
          body = req
        }
      }
}
@Serializable
data class DnsAnswer(val name: String, val type: Int, val TTL: Int, val data: String)
@Serializable
data class DnsQueryRequest(val name: String, val type: String)
@Serializable
data class DnsQueryResponse(val TC: Boolean, val question: List<DnsQuestion>, val status: Int, val AD: Boolean, val CD: Boolean, val RA: Boolean, val RD: Boolean, val answer: List<DnsAnswer>, val provider: String)
@Serializable
data class DnsQuestion(val name: String, val type: Int)
