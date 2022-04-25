
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
internal data class PostcodeLookupRequest({/// UK postcode e.g SW1A 2AA
String? postcode,})
@Serializable
data class PostcodeLookupResponse({/// country e.g United Kingdom
String? country, /// e.g Westminster
String? district, /// e.g 51.50354
double? latitude, /// e.g -0.127695
double? longitude, /// UK postcode e.g SW1A 2AA
String? postcode, /// related region e.g London
String? region, /// e.g St James's
String? ward,})
@Serializable
internal data class PostcodeRandomRequest()
@Serializable
data class PostcodeRandomResponse({/// e.g St James's
String? ward, /// country e.g United Kingdom
String? country, /// e.g Westminster
String? district, /// e.g 51.50354
double? latitude, /// e.g -0.127695
double? longitude, /// UK postcode e.g SW1A 2AA
String? postcode, /// related region e.g London
String? region,})
@Serializable
internal data class PostcodeValidateRequest({/// UK postcode e.g SW1A 2AA
String? postcode,})
@Serializable
data class PostcodeValidateResponse({/// Is the postcode valid (true) or not (false)
bool? valid,})
