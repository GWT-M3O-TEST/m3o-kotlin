
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
internal data class CacheDecrementRequest(val key: String, val value: Long)
@Serializable
data class CacheDecrementResponse(val key: String, val value: Long)
@Serializable
internal data class CacheDeleteRequest(val key: String)
@Serializable
data class CacheDeleteResponse(val status: String)
@Serializable
internal data class CacheGetRequest(val key: String)
@Serializable
data class CacheGetResponse(val key: String, val ttl: Long, val value: String)
@Serializable
internal data class CacheIncrementRequest(val key: String, val value: Long)
@Serializable
data class CacheIncrementResponse(val key: String, val value: Long)
@Serializable
internal data class CacheListKeysRequest()
@Serializable
data class CacheListKeysResponse(val keys: List<CacheString>)
@Serializable
internal data class CacheSetRequest(val ttl: Long, val value: String, val key: String)
@Serializable
data class CacheSetResponse(val status: String)
