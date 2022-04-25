
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "price"

object PriceService {
    suspend fun add(name: String): PriceAddResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Add")) {
          body = PriceAddRequest(name)
        }
    }
    suspend fun get(name: String): PriceGetResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Get")) {
          body = PriceGetRequest(name)
        }
    }
    suspend fun index(name: String): PriceIndexResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Index")) {
          body = PriceIndexRequest(name)
        }
    }
    suspend fun list(name: String): PriceListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = PriceListRequest(name)
        }
    }
    suspend fun report(name: String): PriceReportResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Report")) {
          body = PriceReportRequest(name)
        }
    }
}
@Serializable
internal data class PriceAddRequest({/// symbol of value
String? symbol, /// author of the price
String? author, /// currency e.g USD
String? currency, /// name of the thing e.g bitcoin
String? name, /// price of the thing e.g 10001.00
double? price, /// source of the price
String? source,})
@Serializable
data class PriceAddResponse({Value? value,})
@Serializable
internal data class PriceGetRequest({/// currency to get
String? currency, /// name of the value
String? name, /// symbol of value
String? symbol,})
@Serializable
data class PriceGetResponse({List<Value>? values,})
@Serializable
internal data class PriceIndex({/// currency of value
String? currency, /// name of item
String? name, /// symbol of item
String? symbol,})
@Serializable
internal data class PriceIndexRequest()
@Serializable
data class PriceIndexResponse({List<Index>? index,})
@Serializable
internal data class PriceListRequest({/// currency to get
String? currency, /// limit number of values
int? limit, /// offset to read from
int? offset,})
@Serializable
data class PriceListResponse({List<Value>? values,})
@Serializable
internal data class PriceReport({String? symbol, String? author, String? comment, String? name,})
@Serializable
internal data class PriceReportRequest({/// additional comment
String? comment, /// name of value
String? name, /// symbol of value
String? symbol,})
@Serializable
data class PriceReportResponse()
@Serializable
internal data class PriceValue({/// currency of thing
String? currency, /// name of thing
String? name, /// price of thing
double? price, /// where it came from
String? source, /// symbol of value
String? symbol, /// time it was added
String? timestamp, /// who added it
String? author,})
