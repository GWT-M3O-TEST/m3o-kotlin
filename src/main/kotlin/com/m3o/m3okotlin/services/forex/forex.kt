
package com.m3o.m3okotlin.services.forex

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "forex"

object ForexServ {
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
data class ForexHistoryRequest(val symbol: String? = null)
@Serializable
data class ForexHistoryResponse(val volume: Double? = null, val close: Double? = null, val date: String? = null, val high: Double? = null, val low: Double? = null, val open: Double? = null, val symbol: String? = null)
@Serializable
data class ForexPriceRequest(val symbol: String? = null)
@Serializable
data class ForexPriceResponse(val price: Double? = null, val symbol: String? = null)
@Serializable
data class ForexQuoteRequest(val symbol: String? = null)
@Serializable
data class ForexQuoteResponse(val ask_price: Double? = null, val bid_price: Double? = null, val symbol: String? = null, val timestamp: String? = null)
