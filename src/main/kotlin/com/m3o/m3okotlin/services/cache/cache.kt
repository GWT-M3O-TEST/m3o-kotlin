
package com.m3o.m3okotlin.services.cache

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "cache"

object CacheService {
    suspend fun decrement(req: CacheDecrementRequest): CacheDecrementResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Decrement")) {
          body = req
        }
    }
}
    suspend fun delete(req: CacheDeleteRequest): CacheDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
    }
}
    suspend fun get(req: CacheGetRequest): CacheGetResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Get")) {
          body = req
        }
    }
}
    suspend fun increment(req: CacheIncrementRequest): CacheIncrementResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Increment")) {
          body = req
        }
    }
}
    suspend fun listKeys(): CacheListKeysResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "ListKeys")) 
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
    suspend fun set(req: CacheSetRequest): CacheSetResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Set")) {
          body = req
        }
    }
}
