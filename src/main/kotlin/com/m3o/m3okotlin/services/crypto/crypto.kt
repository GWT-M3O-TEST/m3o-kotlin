
package com.m3o.m3okotlin.services.crypto

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "crypto"

object CryptoService {
    suspend fun history(req: CryptoHistoryRequest): CryptoHistoryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "History")) {
          body = req
        }
    }
    suspend fun news(req: CryptoNewsRequest): CryptoNewsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "News")) {
          body = req
        }
    }
    suspend fun price(req: CryptoPriceRequest): CryptoPriceResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Price")) {
          body = req
        }
    }
    suspend fun quote(req: CryptoQuoteRequest): CryptoQuoteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Quote")) {
          body = req
        }
    }
    suspend fun symbols(req: CryptoSymbolsRequest): CryptoSymbolsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Symbols")) {
          body = req
        }
    }
}
@Serializable
data class CryptoArticle(val source: String, val title: String, val url: String, val date: String, val description: String)
@Serializable
data class CryptoHistoryRequest(val symbol: String)
@Serializable
data class CryptoHistoryResponse(val date: String, val high: Double, val low: Double, val open: Double, val symbol: String, val volume: Double, val close: Double)
@Serializable
data class CryptoNewsRequest(val symbol: String)
@Serializable
data class CryptoNewsResponse(val symbol: String, val articles: List<CryptoArticle>)
@Serializable
data class CryptoPriceRequest(val symbol: String)
@Serializable
data class CryptoPriceResponse(val price: Double, val symbol: String)
@Serializable
data class CryptoQuoteRequest(val symbol: String)
@Serializable
data class CryptoQuoteResponse(val ask_price: Double, val ask_size: Double, val bid_price: Double, val bid_size: Double, val symbol: String, val timestamp: String)
@Serializable
data class CryptoSymbol(val name: String, val symbol: String)
@Serializable
data class CryptoSymbolsRequest()
@Serializable
data class CryptoSymbolsResponse(val symbols: List<CryptoSymbol>)
