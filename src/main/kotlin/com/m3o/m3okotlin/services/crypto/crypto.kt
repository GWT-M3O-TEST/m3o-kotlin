
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
internal data class CryptoArticle()
@Serializable
internal data class CryptoHistoryRequest()
@Serializable
data class CryptoHistoryResponse()
@Serializable
internal data class CryptoNewsRequest()
@Serializable
data class CryptoNewsResponse()
@Serializable
internal data class CryptoPriceRequest()
@Serializable
data class CryptoPriceResponse()
@Serializable
internal data class CryptoQuoteRequest()
@Serializable
data class CryptoQuoteResponse()
@Serializable
internal data class CryptoSymbol()
@Serializable
internal data class CryptoSymbolsRequest()
@Serializable
data class CryptoSymbolsResponse()
