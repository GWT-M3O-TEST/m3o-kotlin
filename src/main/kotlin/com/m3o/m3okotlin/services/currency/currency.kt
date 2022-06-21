
package com.m3o.m3okotlin.services.currency

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "currency"

object CurrencyService {
    suspend fun codes(): CurrencyCodesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Codes")) 
    }
}
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
    suspend fun convert(req: CurrencyConvertRequest): CurrencyConvertResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Convert")) {
          body = req
        }
    }
}
    suspend fun history(req: CurrencyHistoryRequest): CurrencyHistoryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "History")) {
          body = req
        }
    }
}
    suspend fun rates(req: CurrencyRatesRequest): CurrencyRatesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Rates")) {
          body = req
        }
    }
}
