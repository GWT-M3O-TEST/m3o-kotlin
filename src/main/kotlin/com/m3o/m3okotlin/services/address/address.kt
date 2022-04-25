
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
internal data class AddressLookupPostcodeRequest({/// UK postcode e.g SW1A 2AA
String? postcode,})
@Serializable
data class AddressLookupPostcodeResponse({List<Record>? addresses,})
@Serializable
internal data class AddressRecord({/// the premise
String? premise, /// post town
String? town, /// building name
String? building_name, /// line one of address
String? line_one, /// dependent locality
String? locality, /// organisation if present
String? organisation, /// the postcode
String? postcode, /// street name
String? street, /// the complete address
String? summary, /// the county
String? county, /// line two of address
String? line_two,})
