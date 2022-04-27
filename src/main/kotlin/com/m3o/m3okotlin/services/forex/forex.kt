
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
internal data class ForexHistoryRequest()
@Serializable
data class ForexHistoryResponse()
@Serializable
internal data class ForexPriceRequest()
@Serializable
data class ForexPriceResponse()
@Serializable
internal data class ForexQuoteRequest()
@Serializable
data class ForexQuoteResponse()
