
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
internal data class BitcoinPriceRequest()
@Serializable
data class BitcoinPriceResponse()
