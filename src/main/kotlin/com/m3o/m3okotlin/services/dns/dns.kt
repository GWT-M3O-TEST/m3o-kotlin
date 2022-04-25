
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
internal data class DnsAnswer({/// the answer
String? data, /// name resolved
String? name, /// type of record
int? type, /// time to live
int? TTL,})
@Serializable
internal data class DnsQueryRequest({/// name to resolve
String? name, /// type of query e.g A, AAAA, MX, SRV
String? type,})
@Serializable
data class DnsQueryResponse({bool? AD, bool? RA, bool? TC, List<Answer>? answer, int? status, bool? CD, bool? RD, String? provider, List<Question>? question,})
@Serializable
internal data class DnsQuestion({/// name to query
String? name, /// type of record
int? type,})
