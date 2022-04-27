
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "stock"

object StockService {
    suspend fun history(name: String): StockHistoryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "History")) {
          body = StockHistoryRequest(name)
        }
    }
    suspend fun price(name: String): StockPriceResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Price")) {
          body = StockPriceRequest(name)
        }
    }
    suspend fun quote(name: String): StockQuoteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Quote")) {
          body = StockQuoteRequest(name)
        }
    }
}
@Serializable
internal data class StockHistoryRequest()
@Serializable
data class StockHistoryResponse()
@Serializable
internal data class StockPriceRequest()
@Serializable
data class StockPriceResponse()
@Serializable
internal data class StockQuoteRequest()
@Serializable
data class StockQuoteResponse()
