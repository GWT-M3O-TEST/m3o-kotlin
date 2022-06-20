
package com.m3o.m3okotlin.services.price

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "price"

object PriceService {
    suspend fun add(req: PriceAddRequest): PriceAddResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Add")) {
          body = req
        }
    }
    suspend fun get(req: PriceGetRequest): PriceGetResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Get")) {
          body = req
        }
    }
    suspend fun index(req: PriceIndexRequest): PriceIndexResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Index")) {
          body = req
        }
    }
    suspend fun list(req: PriceListRequest): PriceListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = req
        }
    }
    suspend fun report(req: PriceReportRequest): PriceReportResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Report")) {
          body = req
        }
    }
}
@Serializable
data class PriceAddRequest(val currency: String, val name: String, val price: Double, val source: String, val symbol: String, val author: String)
@Serializable
data class PriceAddResponse(val value: PriceValue)
@Serializable
data class PriceGetRequest(val name: String, val symbol: String, val currency: String)
@Serializable
data class PriceGetResponse(val values: List<PriceValue>)
@Serializable
data class PriceIndex(val currency: String, val name: String, val symbol: String)
@Serializable
data class PriceIndexRequest()
@Serializable
data class PriceIndexResponse(val index: List<PriceIndex>)
@Serializable
data class PriceListRequest(val currency: String, val limit: Int, val offset: Int)
@Serializable
data class PriceListResponse(val values: List<PriceValue>)
@Serializable
data class PriceReport(val author: String, val comment: String, val name: String, val symbol: String)
@Serializable
data class PriceReportRequest(val name: String, val symbol: String, val comment: String)
@Serializable
data class PriceReportResponse()
@Serializable
data class PriceValue(val price: Double, val source: String, val symbol: String, val timestamp: String, val author: String, val currency: String, val name: String)
