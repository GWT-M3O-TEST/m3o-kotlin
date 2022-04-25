
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
internal data class DnsAnswer({/// time to live
int? TTL, /// the answer
String? data, /// name resolved
String? name, /// type of record
int? type,})
@Serializable
internal data class DnsQueryRequest({/// type of query e.g A, AAAA, MX, SRV
String? type, /// name to resolve
String? name,})
@Serializable
data class DnsQueryResponse({List<Answer>? answer, String? provider, List<Question>? question, int? status, bool? AD, bool? CD, bool? RA, bool? RD, bool? TC,})
@Serializable
internal data class DnsQuestion({/// type of record
int? type, /// name to query
String? name,})
