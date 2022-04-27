
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
internal data class PriceAddRequest(val author: String, val currency: String, val name: String, val price: Double, val source: String, val symbol: String)
@Serializable
data class PriceAddResponse(val value: PriceValue)
@Serializable
internal data class PriceGetRequest(val symbol: String, val currency: String, val name: String)
@Serializable
data class PriceGetResponse(val values: List<PriceValue>)
@Serializable
internal data class PriceIndex(val currency: String, val name: String, val symbol: String)
@Serializable
internal data class PriceIndexRequest()
@Serializable
data class PriceIndexResponse(val index: List<PriceIndex>)
@Serializable
internal data class PriceListRequest(val limit: Int, val offset: Int, val currency: String)
@Serializable
data class PriceListResponse(val values: List<PriceValue>)
@Serializable
internal data class PriceReport(val symbol: String, val author: String, val comment: String, val name: String)
@Serializable
internal data class PriceReportRequest(val comment: String, val name: String, val symbol: String)
@Serializable
data class PriceReportResponse()
@Serializable
internal data class PriceValue(val price: Double, val source: String, val symbol: String, val timestamp: String, val author: String, val currency: String, val name: String)
