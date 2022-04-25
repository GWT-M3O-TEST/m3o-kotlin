
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "bitcoin"

object BitcoinService {
    suspend fun price(name: String): BitcoinPriceResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Price")) {
          body = BitcoinPriceRequest(name)
        }
    }
}
@Serializable
internal data class BitcoinPriceRequest({/// symbol to use e.g BTCUSD
String? symbol,})
@Serializable
data class BitcoinPriceResponse({/// The price of bitcoin
double? price, /// The symbol of pricing e.g BTCUSD
String? symbol,})
