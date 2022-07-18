
package com.m3o.m3okotlin.services.price

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "price"

object PriceServ {
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
      suspend fun index(): PriceIndexResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Index")) 
      }
      suspend fun list(req: PriceListRequest): PriceListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = req
        }
      }
      suspend fun report(req: PriceReportRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "Report")) {
          body = req
        }
      }
}
@Serializable
data class PriceAddRequest(val symbol: String? = null, val author: String? = null, val currency: String? = null, val name: String? = null, val price: Double? = null, val source: String? = null)
@Serializable
data class PriceAddResponse(val value: PriceValue? = null)
@Serializable
data class PriceGetRequest(val currency: String? = null, val name: String? = null, val symbol: String? = null)
@Serializable
data class PriceGetResponse(val values: List<PriceValue>? = null)
@Serializable
data class PriceIndex(val currency: String? = null, val name: String? = null, val symbol: String? = null)
@Serializable
data class PriceIndexResponse(val index: List<PriceIndex>? = null)
@Serializable
data class PriceListRequest(val currency: String? = null, val limit: Int? = null, val offset: Int? = null)
@Serializable
data class PriceListResponse(val values: List<PriceValue>? = null)
@Serializable
data class PriceReport(val comment: String? = null, val name: String? = null, val symbol: String? = null, val author: String? = null)
@Serializable
data class PriceReportRequest(val symbol: String? = null, val comment: String? = null, val name: String? = null)
@Serializable
data class PriceValue(val name: String? = null, val price: Double? = null, val source: String? = null, val symbol: String? = null, val timestamp: String? = null, val author: String? = null, val currency: String? = null)
