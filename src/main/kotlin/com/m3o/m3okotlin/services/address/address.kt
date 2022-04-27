
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "address"

object AddressService {
    suspend fun lookupPostcode(name: String): AddressLookupPostcodeResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "LookupPostcode")) {
          body = AddressLookupPostcodeRequest(name)
        }
    }
}
@Serializable
internal data class AddressLookupPostcodeRequest()
@Serializable
data class AddressLookupPostcodeResponse()
@Serializable
internal data class AddressRecord()
