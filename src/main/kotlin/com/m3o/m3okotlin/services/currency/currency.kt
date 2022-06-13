
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
    suspend fun codes(req: CurrencyCodesRequest): CurrencyCodesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Codes")) {
          body = req
        }
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
data class CurrencyHistoryResponse(val code: String, val date: String, val rates: Map<String, Double>)
@Serializable
internal data class CurrencyRatesRequest(val code: String)
@Serializable
data class CurrencyRatesResponse(val rates: Map<String, Double>, val code: String)
