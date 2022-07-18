
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
data class DnsAnswer(val type: Int? = null, val TTL: Int? = null, val data: String? = null, val name: String? = null)
@Serializable
data class DnsQueryRequest(val name: String? = null, val type: String? = null)
@Serializable
data class DnsQueryResponse(val RD: Boolean? = null, val answer: List<DnsAnswer>? = null, val provider: String? = null, val question: List<DnsQuestion>? = null, val AD: Boolean? = null, val RA: Boolean? = null, val status: Int? = null, val CD: Boolean? = null, val TC: Boolean? = null)
@Serializable
data class DnsQuestion(val name: String? = null, val type: Int? = null)
