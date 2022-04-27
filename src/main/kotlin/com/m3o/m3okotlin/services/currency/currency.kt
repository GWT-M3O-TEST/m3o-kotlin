
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
internal data class CurrencyCode()
@Serializable
internal data class CurrencyCodesRequest()
@Serializable
data class CurrencyCodesResponse()
@Serializable
internal data class CurrencyConvertRequest()
@Serializable
data class CurrencyConvertResponse()
@Serializable
internal data class CurrencyHistoryRequest()
@Serializable
data class CurrencyHistoryResponse()
@Serializable
internal data class CurrencyRatesRequest()
@Serializable
data class CurrencyRatesResponse()
