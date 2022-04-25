
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "otp"

object OtpService {
    suspend fun generate(name: String): OtpGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
          body = OtpGenerateRequest(name)
        }
    }
    suspend fun validate(name: String): OtpValidateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Validate")) {
          body = OtpValidateRequest(name)
        }
    }
}
@Serializable
internal data class OtpGenerateRequest({/// expiration in seconds (default: 60)

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? expiry
	, /// unique id, email or user to generate an OTP for
String? id, /// number of characters (default: 6)

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? size
	,})
@Serializable
data class OtpGenerateResponse({/// one time pass code
String? code,})
@Serializable
internal data class OtpValidateRequest({/// unique id, email or user for which the code was generated
String? id, /// one time pass code to validate
String? code,})
@Serializable
data class OtpValidateResponse({/// returns true if the code is valid for the ID
bool? success,})
