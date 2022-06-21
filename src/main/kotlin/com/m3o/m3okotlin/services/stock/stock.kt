
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
}
    suspend fun price(req: StockPriceRequest): StockPriceResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Price")) {
          body = req
        }
    }
}
    suspend fun quote(req: StockQuoteRequest): StockQuoteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Quote")) {
          body = req
        }
    }
}
