
package com.m3o.m3okotlin.services.address

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "address"

object AddressService {
      suspend fun lookupPostcode(req: AddressLookupPostcodeRequest): AddressLookupPostcodeResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "LookupPostcode")) {
          body = req
        }
      }
}
@Serializable
data class AddressLookupPostcodeRequest(val postcode: String)
@Serializable
data class AddressLookupPostcodeResponse(val addresses: List<AddressRecord>)
@Serializable
data class AddressRecord(val building_name: String, val county: String, val locality: String, val organisation: String, val premise: String, val summary: String, val line_one: String, val line_two: String, val postcode: String, val street: String, val town: String)
