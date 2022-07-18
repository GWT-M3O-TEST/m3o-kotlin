
package com.m3o.m3okotlin.services.memegen

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "memegen"

object MemegenServ {
      suspend fun generate(req: MemegenGenerateRequest): MemegenGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
          body = req
        }
      }
      suspend fun templates(): MemegenTemplatesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Templates")) 
      }
}
@Serializable
data class MemegenBox(val height: Int? = null, val outline: String? = null, val text: String? = null, val width: Int? = null, val x: Int? = null, val y: Int? = null, val color: String? = null)
@Serializable
data class MemegenGenerateRequest(val max_font_size: String? = null, val top_text: String? = null, val bottom_text: String? = null, val font: String? = null, val id: String? = null)
@Serializable
data class MemegenGenerateResponse(val url: String? = null)
@Serializable
data class MemegenTemplate(val height: Int? = null, val id: String? = null, val name: String? = null, val url: String? = null, val width: Int? = null, val box_count: Int? = null)
@Serializable
data class MemegenTemplatesResponse(val templates: List<MemegenTemplate>? = null)
