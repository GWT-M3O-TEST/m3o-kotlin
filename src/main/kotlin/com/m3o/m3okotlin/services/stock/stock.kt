
package com.m3o.m3okotlin.services.stock

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "stock"

object StockServ {
      suspend fun history(req: StockHistoryRequest): StockHistoryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "History")) {
          body = req
        }
      }
      suspend fun price(req: StockPriceRequest): StockPriceResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Price")) {
          body = req
        }
      }
      suspend fun quote(req: StockQuoteRequest): StockQuoteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Quote")) {
          body = req
        }
      }
}
@Serializable
data class StockHistoryRequest(val date: String? = null, val stock: String? = null)
@Serializable
data class StockHistoryResponse(val open: Double? = null, val symbol: String? = null, val volume: Int? = null, val close: Double? = null, val date: String? = null, val high: Double? = null, val low: Double? = null)
@Serializable
data class StockPriceRequest(val symbol: String? = null)
@Serializable
data class StockPriceResponse(val price: Double? = null, val symbol: String? = null)
@Serializable
data class StockQuoteRequest(val symbol: String? = null)
@Serializable
data class StockQuoteResponse(val bid_size: Int? = null, val symbol: String? = null, val timestamp: String? = null, val ask_price: Double? = null, val ask_size: Int? = null, val bid_price: Double? = null)
