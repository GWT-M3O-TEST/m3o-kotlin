
package com.m3o.m3okotlin.services.memegen

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "memegen"

object MemegenService {
    suspend fun generate(req: MemegenGenerateRequest): MemegenGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
          body = req
        }
    }
}
    suspend fun templates(): MemegenTemplatesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Templates")) 
    }
}
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
