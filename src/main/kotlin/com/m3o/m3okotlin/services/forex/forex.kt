
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "forex"

object ForexService {
    suspend fun history(name: String): ForexHistoryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "History")) {
          body = ForexHistoryRequest(name)
        }
    }
    suspend fun price(name: String): ForexPriceResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Price")) {
          body = ForexPriceRequest(name)
        }
    }
    suspend fun quote(name: String): ForexQuoteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Quote")) {
          body = ForexQuoteRequest(name)
        }
    }
}
@Serializable
internal data class ForexHistoryRequest({/// the forex symbol e.g GBPUSD
String? symbol,})
@Serializable
data class ForexHistoryResponse({/// the close price
double? close, /// the date
String? date, /// the peak price
double? high, /// the low price
double? low, /// the open price
double? open, /// the forex symbol
String? symbol, /// the volume
double? volume,})
@Serializable
internal data class ForexPriceRequest({/// forex symbol e.g GBPUSD
String? symbol,})
@Serializable
data class ForexPriceResponse({/// the last price
double? price, /// the forex symbol e.g GBPUSD
String? symbol,})
@Serializable
internal data class ForexQuoteRequest({/// the forex symbol e.g GBPUSD
String? symbol,})
@Serializable
data class ForexQuoteResponse({/// the asking price
double? ask_price, /// the bidding price
double? bid_price, /// the forex symbol
String? symbol, /// the UTC timestamp of the quote
String? timestamp,})
