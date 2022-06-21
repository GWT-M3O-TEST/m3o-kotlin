
package com.m3o.m3okotlin.services.price

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "price"

object PriceService {
    suspend fun add(req: PriceAddRequest): PriceAddResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Add")) {
          body = req
        }
    }
}
    suspend fun get(req: PriceGetRequest): PriceGetResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Get")) {
          body = req
        }
    }
}
    suspend fun index(): PriceIndexResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Index")) 
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
// generate nothing
    suspend fun list(req: PriceListRequest): PriceListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = req
        }
    }
}
    suspend fun report(req: PriceReportRequest){
      return ktorHttpClient.post(getUrl(SERVICE, "Report")) {
        body = req
      }
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
// generate nothing
