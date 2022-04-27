
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "postcode"

object PostcodeService {
    suspend fun lookup(name: String): PostcodeLookupResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Lookup")) {
          body = PostcodeLookupRequest(name)
        }
    }
    suspend fun random(name: String): PostcodeRandomResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Random")) {
          body = PostcodeRandomRequest(name)
        }
    }
    suspend fun validate(name: String): PostcodeValidateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Validate")) {
          body = PostcodeValidateRequest(name)
        }
    }
}
@Serializable
internal data class PostcodeLookupRequest()
@Serializable
data class PostcodeLookupResponse()
@Serializable
internal data class PostcodeRandomRequest()
@Serializable
data class PostcodeRandomResponse()
@Serializable
internal data class PostcodeValidateRequest()
@Serializable
data class PostcodeValidateResponse()
