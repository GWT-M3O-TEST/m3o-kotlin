
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
}
    suspend fun price(req: ForexPriceRequest): ForexPriceResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Price")) {
          body = req
        }
    }
}
    suspend fun quote(req: ForexQuoteRequest): ForexQuoteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Quote")) {
          body = req
        }
    }
}
