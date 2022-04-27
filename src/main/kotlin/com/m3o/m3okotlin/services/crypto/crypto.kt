
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "crypto"

object CryptoService {
    suspend fun history(name: String): CryptoHistoryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "History")) {
          body = CryptoHistoryRequest(name)
        }
    }
    suspend fun news(name: String): CryptoNewsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "News")) {
          body = CryptoNewsRequest(name)
        }
    }
    suspend fun price(name: String): CryptoPriceResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Price")) {
          body = CryptoPriceRequest(name)
        }
    }
    suspend fun quote(name: String): CryptoQuoteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Quote")) {
          body = CryptoQuoteRequest(name)
        }
    }
    suspend fun symbols(name: String): CryptoSymbolsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Symbols")) {
          body = CryptoSymbolsRequest(name)
        }
    }
}
@Serializable
internal data class CryptoArticle(val date: String, val description: String, val source: String, val title: String, val url: String)
@Serializable
internal data class CryptoHistoryRequest(val symbol: String)
@Serializable
data class CryptoHistoryResponse(val date: String, val high: Double, val low: Double, val open: Double, val symbol: String, val volume: Double, val close: Double)
@Serializable
internal data class CryptoNewsRequest(val symbol: String)
@Serializable
data class CryptoNewsResponse(val articles: List<CryptoArticle>, val symbol: String)
@Serializable
internal data class CryptoPriceRequest(val symbol: String)
@Serializable
data class CryptoPriceResponse(val price: Double, val symbol: String)
@Serializable
internal data class CryptoQuoteRequest(val symbol: String)
@Serializable
data class CryptoQuoteResponse(val ask_size: Double, val bid_price: Double, val bid_size: Double, val symbol: String, val timestamp: String, val ask_price: Double)
@Serializable
internal data class CryptoSymbol(val name: String, val symbol: String)
@Serializable
internal data class CryptoSymbolsRequest()
@Serializable
data class CryptoSymbolsResponse(val symbols: List<CryptoSymbol>)
