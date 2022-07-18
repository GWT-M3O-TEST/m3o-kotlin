
package com.m3o.m3okotlin.services.postcode

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "postcode"

object PostcodeServ {
      suspend fun lookup(req: PostcodeLookupRequest): PostcodeLookupResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Lookup")) {
          body = req
        }
      }
      suspend fun random(): PostcodeRandomResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Random")) 
      }
      suspend fun validate(req: PostcodeValidateRequest): PostcodeValidateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Validate")) {
          body = req
        }
      }
}
@Serializable
data class PostcodeLookupRequest(val postcode: String? = null)
@Serializable
data class PostcodeLookupResponse(val region: String? = null, val ward: String? = null, val country: String? = null, val district: String? = null, val latitude: Double? = null, val longitude: Double? = null, val postcode: String? = null)
@Serializable
data class PostcodeRandomResponse(val country: String? = null, val district: String? = null, val latitude: Double? = null, val longitude: Double? = null, val postcode: String? = null, val region: String? = null, val ward: String? = null)
@Serializable
data class PostcodeValidateRequest(val postcode: String? = null)
@Serializable
data class PostcodeValidateResponse(val valid: Boolean? = null)
