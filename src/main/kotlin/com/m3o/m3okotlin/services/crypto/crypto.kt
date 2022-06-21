
package com.m3o.m3okotlin.services.crypto

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "crypto"

object CryptoService {
    suspend fun history(req: CryptoHistoryRequest): CryptoHistoryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "History")) {
          body = req
        }
    }
}
    suspend fun news(req: CryptoNewsRequest): CryptoNewsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "News")) {
          body = req
        }
    }
}
    suspend fun price(req: CryptoPriceRequest): CryptoPriceResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Price")) {
          body = req
        }
    }
}
    suspend fun quote(req: CryptoQuoteRequest): CryptoQuoteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Quote")) {
          body = req
        }
    }
}
    suspend fun symbols(): CryptoSymbolsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Symbols")) 
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
// generate nothing
// generate nothing
// generate nothing
