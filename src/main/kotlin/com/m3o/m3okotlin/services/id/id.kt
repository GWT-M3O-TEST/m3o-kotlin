
package com.m3o.m3okotlin.services.id

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "id"

object IdServ {
      suspend fun generate(req: IdGenerateRequest): IdGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
          body = req
        }
      }
      suspend fun types(): IdTypesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Types")) 
      }
}
@Serializable
data class IdGenerateRequest(val type: String? = null)
@Serializable
data class IdGenerateResponse(val id: String? = null, val type: String? = null)
@Serializable
data class IdTypesResponse(val types: List<String>? = null)
