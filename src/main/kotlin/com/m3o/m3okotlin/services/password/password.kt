
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "password"

object PasswordService {
    suspend fun generate(name: String): PasswordGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
          body = PasswordGenerateRequest(name)
        }
    }
}
@Serializable
internal data class PasswordGenerateRequest({/// password length; defaults to 8 chars
int? length, /// include lowercase letters
bool? lowercase, /// include numbers
bool? numbers, /// include special characters (!@#$%&*)
bool? special, /// include uppercase letters
bool? uppercase,})
@Serializable
data class PasswordGenerateResponse({/// The generated password
String? password,})
