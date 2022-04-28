
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "currency"

object CurrencyService {
    suspend fun codes(name: String): CurrencyCodesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Codes")) {
          body = CurrencyCodesRequest(name)
        }
    }
    suspend fun convert(name: String): CurrencyConvertResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Convert")) {
          body = CurrencyConvertRequest(name)
        }
    }
    suspend fun history(name: String): CurrencyHistoryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "History")) {
          body = CurrencyHistoryRequest(name)
        }
    }
    suspend fun rates(name: String): CurrencyRatesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Rates")) {
          body = CurrencyRatesRequest(name)
        }
    }
}
@Serializable
internal data class CurrencyCode(val currency: String, val name: String)
@Serializable
internal data class CurrencyCodesRequest()
@Serializable
data class CurrencyCodesResponse(val codes: List<CurrencyCode>)
@Serializable
internal data class CurrencyConvertRequest(val amount: Double, val from: String, val to: String)
@Serializable
data class CurrencyConvertResponse(val amount: Double, val from: String, val rate: Double, val to: String)
@Serializable
internal data class CurrencyHistoryRequest(val code: String, val date: String)
@Serializable
data class CurrencyHistoryResponse(val rates: Map<String, Double>, val code: String, val date: String)
@Serializable
internal data class CurrencyRatesRequest(val code: String)
@Serializable
data class CurrencyRatesResponse(val code: String, val rates: Map<String, Double>)
