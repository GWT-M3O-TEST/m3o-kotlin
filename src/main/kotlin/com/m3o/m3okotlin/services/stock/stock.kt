
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
internal data class StockHistoryRequest({/// date to retrieve as YYYY-MM-DD
String? date, /// the stock symbol e.g AAPL
String? stock,})
@Serializable
data class StockHistoryResponse({/// the close price
double? close, /// the date
String? date, /// the peak price
double? high, /// the low price
double? low, /// the open price
double? open, /// the stock symbol
String? symbol, /// the volume
int? volume,})
@Serializable
internal data class StockPriceRequest({/// stock symbol e.g AAPL
String? symbol,})
@Serializable
data class StockPriceResponse({/// the last price
double? price, /// the stock symbol e.g AAPL
String? symbol,})
@Serializable
internal data class StockQuoteRequest({/// the stock symbol e.g AAPL
String? symbol,})
@Serializable
data class StockQuoteResponse({/// the asking price
double? ask_price, /// the ask size
int? ask_size, /// the bidding price
double? bid_price, /// the bid size
int? bid_size, /// the stock symbol
String? symbol, /// the UTC timestamp of the quote
String? timestamp,})
