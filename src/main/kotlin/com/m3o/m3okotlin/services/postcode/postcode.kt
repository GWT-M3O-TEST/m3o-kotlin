
package com.m3o.m3okotlin.services.postcode

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "postcode"

object PostcodeService {
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
data class PostcodeLookupRequest(val postcode: String)
@Serializable
data class PostcodeLookupResponse(val country: String, val district: String, val latitude: Double, val longitude: Double, val postcode: String, val region: String, val ward: String)
@Serializable
data class PostcodeRandomResponse(val latitude: Double, val longitude: Double, val postcode: String, val region: String, val ward: String, val country: String, val district: String)
@Serializable
data class PostcodeValidateRequest(val postcode: String)
@Serializable
data class PostcodeValidateResponse(val valid: Boolean)
