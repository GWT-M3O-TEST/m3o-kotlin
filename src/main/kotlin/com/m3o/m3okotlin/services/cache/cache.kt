
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "cache"

object CacheService {
    suspend fun decrement(name: String): CacheDecrementResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Decrement")) {
          body = CacheDecrementRequest(name)
        }
    }
    suspend fun delete(name: String): CacheDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = CacheDeleteRequest(name)
        }
    }
    suspend fun get(name: String): CacheGetResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Get")) {
          body = CacheGetRequest(name)
        }
    }
    suspend fun increment(name: String): CacheIncrementResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Increment")) {
          body = CacheIncrementRequest(name)
        }
    }
    suspend fun listKeys(name: String): CacheListKeysResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "ListKeys")) {
          body = CacheListKeysRequest(name)
        }
    }
    suspend fun set(name: String): CacheSetResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Set")) {
          body = CacheSetRequest(name)
        }
    }
}
@Serializable
internal data class CacheDecrementRequest()
@Serializable
data class CacheDecrementResponse()
@Serializable
internal data class CacheDeleteRequest()
@Serializable
data class CacheDeleteResponse()
@Serializable
internal data class CacheGetRequest()
@Serializable
data class CacheGetResponse()
@Serializable
internal data class CacheIncrementRequest()
@Serializable
data class CacheIncrementResponse()
@Serializable
internal data class CacheListKeysRequest()
@Serializable
data class CacheListKeysResponse()
@Serializable
internal data class CacheSetRequest()
@Serializable
data class CacheSetResponse()
