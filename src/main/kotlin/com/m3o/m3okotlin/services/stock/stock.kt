
package com.m3o.m3okotlin.services.stock

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "stock"

object StockService {
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
data class StockHistoryRequest(val stock: String, val date: String)
@Serializable
data class StockHistoryResponse(val volume: Int, val close: Double, val date: String, val high: Double, val low: Double, val open: Double, val symbol: String)
@Serializable
data class StockPriceRequest(val symbol: String)
@Serializable
data class StockPriceResponse(val price: Double, val symbol: String)
@Serializable
data class StockQuoteRequest(val symbol: String)
@Serializable
data class StockQuoteResponse(val ask_price: Double, val ask_size: Int, val bid_price: Double, val bid_size: Int, val symbol: String, val timestamp: String)
