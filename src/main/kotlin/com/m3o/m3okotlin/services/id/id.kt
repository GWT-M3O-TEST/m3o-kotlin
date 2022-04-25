
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "id"

object IdService {
    suspend fun generate(name: String): IdGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
          body = IdGenerateRequest(name)
        }
    }
    suspend fun types(name: String): IdTypesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Types")) {
          body = IdTypesRequest(name)
        }
    }
}
@Serializable
internal data class IdGenerateRequest({/// type of id e.g uuid, shortid, snowflake (64 bit), bigflake (128 bit)
String? type,})
@Serializable
data class IdGenerateResponse({/// the unique id generated
String? id, /// the type of id generated
String? type,})
@Serializable
internal data class IdTypesRequest()
@Serializable
data class IdTypesResponse({List<String>? types,})
