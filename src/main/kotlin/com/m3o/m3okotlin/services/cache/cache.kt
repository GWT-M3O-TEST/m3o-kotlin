
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
internal data class CacheDecrementRequest({/// The amount to decrement the value by

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? value
	, /// The key to decrement
String? key,})
@Serializable
data class CacheDecrementResponse({/// The key decremented
String? key, /// The new value

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? value
	,})
@Serializable
internal data class CacheDeleteRequest({/// The key to delete
String? key,})
@Serializable
data class CacheDeleteResponse({/// Returns "ok" if successful
String? status,})
@Serializable
internal data class CacheGetRequest({/// The key to retrieve
String? key,})
@Serializable
data class CacheGetResponse({/// The key
String? key, /// Time to live in seconds

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? ttl
	, /// The value
String? value,})
@Serializable
internal data class CacheIncrementRequest({/// The key to increment
String? key, /// The amount to increment the value by

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? value
	,})
@Serializable
data class CacheIncrementResponse({/// The key incremented
String? key, /// The new value

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? value
	,})
@Serializable
internal data class CacheListKeysRequest()
@Serializable
data class CacheListKeysResponse({List<String>? keys,})
@Serializable
internal data class CacheSetRequest({/// The value to set
String? value, /// The key to update
String? key, /// Time to live in seconds

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? ttl
	,})
@Serializable
data class CacheSetResponse({/// Returns "ok" if successful
String? status,})
