
package com.m3o.m3okotlin.services.cache

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "cache"

object CacheServ {
      suspend fun decrement(req: CacheDecrementRequest): CacheDecrementResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Decrement")) {
          body = req
        }
      }
      suspend fun delete(req: CacheDeleteRequest): CacheDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
      }
      suspend fun get(req: CacheGetRequest): CacheGetResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Get")) {
          body = req
        }
      }
      suspend fun increment(req: CacheIncrementRequest): CacheIncrementResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Increment")) {
          body = req
        }
      }
      suspend fun listKeys(): CacheListKeysResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "ListKeys")) 
      }
      suspend fun set(req: CacheSetRequest): CacheSetResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Set")) {
          body = req
        }
      }
}
@Serializable
data class CacheDecrementRequest(val key: String? = null, val value: Long? = null)
@Serializable
data class CacheDecrementResponse(val value: Long? = null, val key: String? = null)
@Serializable
data class CacheDeleteRequest(val key: String? = null)
@Serializable
data class CacheDeleteResponse(val status: String? = null)
@Serializable
data class CacheGetRequest(val key: String? = null)
@Serializable
data class CacheGetResponse(val key: String? = null, val ttl: Long? = null, val value: String? = null)
@Serializable
data class CacheIncrementRequest(val key: String? = null, val value: Long? = null)
@Serializable
data class CacheIncrementResponse(val key: String? = null, val value: Long? = null)
@Serializable
data class CacheListKeysResponse(val keys: List<String>? = null)
@Serializable
data class CacheSetRequest(val key: String? = null, val ttl: Long? = null, val value: String? = null)
@Serializable
data class CacheSetResponse(val status: String? = null)
