
package com.m3o.m3okotlin.services.bitcoin

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "bitcoin"

object BitcoinService {
      suspend fun balance(req: BitcoinBalanceRequest): BitcoinBalanceResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Balance")) {
          body = req
        }
      }
      suspend fun price(req: BitcoinPriceRequest): BitcoinPriceResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Price")) {
          body = req
        }
      }
      suspend fun transaction(req: BitcoinTransactionRequest): BitcoinTransactionResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Transaction")) {
          body = req
        }
      }
}
@Serializable
data class BitcoinBalanceRequest(val address: String)
@Serializable
data class BitcoinBalanceResponse(val balance: Long)
@Serializable
data class BitcoinInput(val prev_out: BitcoinPrev, val script: String)
@Serializable
data class BitcoinOutput(val address: String, val hash: String, val script: String, val spent: Boolean, val tx_index: Long, val value: Long)
@Serializable
data class BitcoinPrev(val address: String, val n: Long, val script: String, val spent: Boolean, val tx_index: Long, val value: Long)
@Serializable
data class BitcoinPriceRequest(val symbol: String)
@Serializable
data class BitcoinPriceResponse(val price: Double, val symbol: String)
@Serializable
data class BitcoinTransactionRequest(val hash: String)
@Serializable
data class BitcoinTransactionResponse(val weight: Long, val double_spend: Boolean, val version: Long, val block_height: Long, val outputs: List<BitcoinOutput>, val relay: String, val size: Long, val block_index: Long, val hash: String, val lock_time: Long, val tx_index: Long, val vin_sz: Long, val vout_sz: Long, val fee: Long, val inputs: List<BitcoinInput>)
