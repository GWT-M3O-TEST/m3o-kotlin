
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
      suspend fun templates(): MemegenTemplatesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Templates")) 
      }
}
@Serializable
data class MemegenBox(val text: String, val width: Int, val x: Int, val y: Int, val color: String, val height: Int, val outline: String)
@Serializable
data class MemegenGenerateRequest(val font: String, val id: String, val max_font_size: String, val top_text: String, val bottom_text: String)
@Serializable
data class MemegenGenerateResponse(val url: String)
@Serializable
data class MemegenTemplate(val box_count: Int, val height: Int, val id: String, val name: String, val url: String, val width: Int)
@Serializable
data class MemegenTemplatesResponse(val templates: List<MemegenTemplate>)
