
package com.m3o.m3okotlin.services.password

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "password"

object PasswordService {
      suspend fun generate(req: PasswordGenerateRequest): PasswordGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
          body = req
        }
      }
}
@Serializable
data class PasswordGenerateRequest(val uppercase: Boolean, val length: Int, val lowercase: Boolean, val numbers: Boolean, val special: Boolean)
@Serializable
data class PasswordGenerateResponse(val password: String)
