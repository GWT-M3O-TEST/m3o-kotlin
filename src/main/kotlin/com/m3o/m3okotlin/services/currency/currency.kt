
package com.m3o.m3okotlin.services.currency

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "currency"

object CurrencyServ {
      suspend fun codes(): CurrencyCodesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Codes")) 
      }
      suspend fun convert(req: CurrencyConvertRequest): CurrencyConvertResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Convert")) {
          body = req
        }
      }
      suspend fun history(req: CurrencyHistoryRequest): CurrencyHistoryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "History")) {
          body = req
        }
      }
      suspend fun rates(req: CurrencyRatesRequest): CurrencyRatesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Rates")) {
          body = req
        }
      }
}
@Serializable
data class CurrencyCode(val currency: String? = null, val name: String? = null)
@Serializable
data class CurrencyCodesResponse(val codes: List<CurrencyCode>? = null)
@Serializable
data class CurrencyConvertRequest(val amount: Double? = null, val from: String? = null, val to: String? = null)
@Serializable
data class CurrencyConvertResponse(val amount: Double? = null, val from: String? = null, val rate: Double? = null, val to: String? = null)
@Serializable
data class CurrencyHistoryRequest(val date: String? = null, val code: String? = null)
@Serializable
data class CurrencyHistoryResponse(val code: String? = null, val date: String? = null, val rates: Map<String, Double>? = null)
@Serializable
data class CurrencyRatesRequest(val code: String? = null)
@Serializable
data class CurrencyRatesResponse(val code: String? = null, val rates: Map<String, Double>? = null)
