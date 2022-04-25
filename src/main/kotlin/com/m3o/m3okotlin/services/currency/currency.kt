
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
internal data class CurrencyCode({/// e.g United States Dollar
String? currency, /// e.g USD
String? name,})
@Serializable
internal data class CurrencyCodesRequest()
@Serializable
data class CurrencyCodesResponse({List<Code>? codes,})
@Serializable
internal data class CurrencyConvertRequest({/// optional amount to convert e.g 10.0
double? amount, /// base code to convert from e.g USD
String? from, /// target code to convert to e.g GBP
String? to,})
@Serializable
data class CurrencyConvertResponse({/// converted amount e.g 7.10
double? amount, /// the base code e.g USD
String? from, /// conversion rate e.g 0.71
double? rate, /// the target code e.g GBP
String? to,})
@Serializable
internal data class CurrencyHistoryRequest({/// currency code e.g USD
String? code, /// date formatted as YYYY-MM-DD
String? date,})
@Serializable
data class CurrencyHistoryResponse({/// The date requested
String? date, /// The rate for the day as code:rate
Map<String, double>? rates, /// The code of the request
String? code,})
@Serializable
internal data class CurrencyRatesRequest({/// The currency code to get rates for e.g USD
String? code,})
@Serializable
data class CurrencyRatesResponse({/// The code requested e.g USD
String? code, /// The rates for the given code as key-value pairs code:rate
Map<String, double>? rates,})
