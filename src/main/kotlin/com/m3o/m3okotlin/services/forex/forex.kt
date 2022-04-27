
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
internal data class ForexHistoryRequest(val symbol: String)
@Serializable
data class ForexHistoryResponse(val open: Double, val symbol: String, val volume: Double, val close: Double, val date: String, val high: Double, val low: Double)
@Serializable
internal data class ForexPriceRequest(val symbol: String)
@Serializable
data class ForexPriceResponse(val price: Double, val symbol: String)
@Serializable
internal data class ForexQuoteRequest(val symbol: String)
@Serializable
data class ForexQuoteResponse(val ask_price: Double, val bid_price: Double, val symbol: String, val timestamp: String)
