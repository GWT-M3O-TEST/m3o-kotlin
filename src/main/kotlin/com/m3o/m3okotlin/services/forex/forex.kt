
package com.m3o.m3okotlin.services.forex

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "forex"

object ForexService {
    suspend fun history(req: ForexHistoryRequest): ForexHistoryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "History")) {
          body = req
        }
    }
    suspend fun price(req: ForexPriceRequest): ForexPriceResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Price")) {
          body = req
        }
    }
    suspend fun quote(req: ForexQuoteRequest): ForexQuoteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Quote")) {
          body = req
        }
    }
}
@Serializable
data class ForexHistoryRequest(val symbol: String)
@Serializable
data class ForexHistoryResponse(val date: String, val high: Double, val low: Double, val open: Double, val symbol: String, val volume: Double, val close: Double)
@Serializable
data class ForexPriceRequest(val symbol: String)
@Serializable
data class ForexPriceResponse(val price: Double, val symbol: String)
@Serializable
data class ForexQuoteRequest(val symbol: String)
@Serializable
data class ForexQuoteResponse(val ask_price: Double, val bid_price: Double, val symbol: String, val timestamp: String)
