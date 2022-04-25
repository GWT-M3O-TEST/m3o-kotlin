
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
internal data class CryptoArticle({/// the date published
String? date, /// its description
String? description, /// the source
String? source, /// title of the article
String? title, /// the source url
String? url,})
@Serializable
internal data class CryptoHistoryRequest({/// the crypto symbol e.g BTCUSD
String? symbol,})
@Serializable
data class CryptoHistoryResponse({/// the crypto symbol
String? symbol, /// the volume
double? volume, /// the close price
double? close, /// the date
String? date, /// the peak price
double? high, /// the low price
double? low, /// the open price
double? open,})
@Serializable
internal data class CryptoNewsRequest({/// cryptocurrency ticker to request news for e.g BTC
String? symbol,})
@Serializable
data class CryptoNewsResponse({/// list of articles
List<Article>? articles, /// symbol requested for
String? symbol,})
@Serializable
internal data class CryptoPriceRequest({/// the crypto symbol e.g BTCUSD
String? symbol,})
@Serializable
data class CryptoPriceResponse({/// the last price
double? price, /// the crypto symbol e.g BTCUSD
String? symbol,})
@Serializable
internal data class CryptoQuoteRequest({/// the crypto symbol e.g BTCUSD
String? symbol,})
@Serializable
data class CryptoQuoteResponse({/// the ask size
double? ask_size, /// the bidding price
double? bid_price, /// the bid size
double? bid_size, /// the crypto symbol
String? symbol, /// the UTC timestamp of the quote
String? timestamp, /// the asking price
double? ask_price,})
@Serializable
internal data class CryptoSymbol({String? name, String? symbol,})
@Serializable
internal data class CryptoSymbolsRequest()
@Serializable
data class CryptoSymbolsResponse({List<Symbol>? symbols,})
