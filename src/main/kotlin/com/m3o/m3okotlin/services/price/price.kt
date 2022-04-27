
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
internal data class PriceAddRequest()
@Serializable
data class PriceAddResponse()
@Serializable
internal data class PriceGetRequest()
@Serializable
data class PriceGetResponse()
@Serializable
internal data class PriceIndex()
@Serializable
internal data class PriceIndexRequest()
@Serializable
data class PriceIndexResponse()
@Serializable
internal data class PriceListRequest()
@Serializable
data class PriceListResponse()
@Serializable
internal data class PriceReport()
@Serializable
internal data class PriceReportRequest()
@Serializable
data class PriceReportResponse()
@Serializable
internal data class PriceValue()
