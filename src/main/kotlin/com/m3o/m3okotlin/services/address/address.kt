
package com.m3o.m3okotlin.services.address

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "address"

object AddressServ {
      suspend fun lookupPostcode(req: AddressLookupPostcodeRequest): AddressLookupPostcodeResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "LookupPostcode")) {
          body = req
        }
      }
}
@Serializable
data class AddressLookupPostcodeRequest(val postcode: String? = null)
@Serializable
data class AddressLookupPostcodeResponse(val addresses: List<AddressRecord>? = null)
@Serializable
data class AddressRecord(val building_name: String? = null, val line_one: String? = null, val line_two: String? = null, val locality: String? = null, val postcode: String? = null, val street: String? = null, val summary: String? = null, val county: String? = null, val organisation: String? = null, val premise: String? = null, val town: String? = null)
