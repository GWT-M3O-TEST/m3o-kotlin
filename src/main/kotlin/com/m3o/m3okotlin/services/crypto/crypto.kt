
package com.m3o.m3okotlin.services.crypto

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "crypto"

object CryptoServ {
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
      suspend fun symbols(): CryptoSymbolsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Symbols")) 
      }
}
@Serializable
data class CryptoArticle(val date: String? = null, val description: String? = null, val source: String? = null, val title: String? = null, val url: String? = null)
@Serializable
data class CryptoHistoryRequest(val symbol: String? = null)
@Serializable
data class CryptoHistoryResponse(val high: Double? = null, val low: Double? = null, val open: Double? = null, val symbol: String? = null, val volume: Double? = null, val close: Double? = null, val date: String? = null)
@Serializable
data class CryptoNewsRequest(val symbol: String? = null)
@Serializable
data class CryptoNewsResponse(val articles: List<CryptoArticle>? = null, val symbol: String? = null)
@Serializable
data class CryptoPriceRequest(val symbol: String? = null)
@Serializable
data class CryptoPriceResponse(val price: Double? = null, val symbol: String? = null)
@Serializable
data class CryptoQuoteRequest(val symbol: String? = null)
@Serializable
data class CryptoQuoteResponse(val ask_price: Double? = null, val ask_size: Double? = null, val bid_price: Double? = null, val bid_size: Double? = null, val symbol: String? = null, val timestamp: String? = null)
@Serializable
data class CryptoSymbol(val name: String? = null, val symbol: String? = null)
@Serializable
data class CryptoSymbolsResponse(val symbols: List<CryptoSymbol>? = null)
