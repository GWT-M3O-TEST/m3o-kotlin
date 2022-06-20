
package com.m3o.m3okotlin.services.bitcoin

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "bitcoin"

object BitcoinService {
    suspend fun price(req: BitcoinPriceRequest): BitcoinPriceResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Price")) {
          body = req
        }
    }
}
@Serializable
data class BitcoinPriceRequest(val symbol: String)
@Serializable
data class BitcoinPriceResponse(val symbol: String, val price: Double)
