
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
data class BitcoinOutput(val tx_index: Long, val value: Long, val address: String, val hash: String, val script: String, val spent: Boolean)
@Serializable
data class BitcoinPrev(val n: Long, val script: String, val spent: Boolean, val tx_index: Long, val value: Long, val address: String)
@Serializable
data class BitcoinPriceRequest(val symbol: String)
@Serializable
data class BitcoinPriceResponse(val price: Double, val symbol: String)
@Serializable
data class BitcoinTransactionRequest(val hash: String)
@Serializable
data class BitcoinTransactionResponse(val fee: Long, val outputs: List<BitcoinOutput>, val relay: String, val size: Long, val vout_sz: Long, val double_spend: Boolean, val inputs: List<BitcoinInput>, val weight: Long, val tx_index: Long, val version: Long, val vin_sz: Long, val block_height: Long, val block_index: Long, val hash: String, val lock_time: Long)
