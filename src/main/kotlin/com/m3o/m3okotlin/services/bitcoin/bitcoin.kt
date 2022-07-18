
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

object BitcoinServ {
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
data class BitcoinBalanceRequest(val address: String? = null)
@Serializable
data class BitcoinBalanceResponse(val balance: Long? = null)
@Serializable
data class BitcoinInput(val prev_out: BitcoinPrev? = null, val script: String? = null)
@Serializable
data class BitcoinOutput(val tx_index: Long? = null, val value: Long? = null, val address: String? = null, val hash: String? = null, val script: String? = null, val spent: Boolean? = null)
@Serializable
data class BitcoinPrev(val spent: Boolean? = null, val tx_index: Long? = null, val value: Long? = null, val address: String? = null, val n: Long? = null, val script: String? = null)
@Serializable
data class BitcoinPriceRequest(val symbol: String? = null)
@Serializable
data class BitcoinPriceResponse(val price: Double? = null, val symbol: String? = null)
@Serializable
data class BitcoinTransactionRequest(val hash: String? = null)
@Serializable
data class BitcoinTransactionResponse(val version: Long? = null, val fee: Long? = null, val size: Long? = null, val hash: String? = null, val lock_time: Long? = null, val outputs: List<BitcoinOutput>? = null, val vin_sz: Long? = null, val block_index: Long? = null, val double_spend: Boolean? = null, val inputs: List<BitcoinInput>? = null, val relay: String? = null, val tx_index: Long? = null, val vout_sz: Long? = null, val weight: Long? = null, val block_height: Long? = null)
