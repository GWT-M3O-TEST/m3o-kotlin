
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

object DnsServ {
      suspend fun query(req: DnsQueryRequest): DnsQueryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Query")) {
          body = req
        }
      }
}
@Serializable
data class DnsAnswer(val TTL: Int, val data: String, val name: String, val type: Int)
@Serializable
data class DnsQueryRequest(val type: String, val name: String)
@Serializable
data class DnsQueryResponse(val TC: Boolean, val answer: List<DnsAnswer>, val provider: String, val question: List<DnsQuestion>, val AD: Boolean, val CD: Boolean, val status: Int, val RA: Boolean, val RD: Boolean)
@Serializable
data class DnsQuestion(val name: String, val type: Int)
