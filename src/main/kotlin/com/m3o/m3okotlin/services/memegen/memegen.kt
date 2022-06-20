
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
    suspend fun templates(req: MemegenTemplatesRequest): MemegenTemplatesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Templates")) {
          body = req
        }
    }
}
@Serializable
data class MemegenBox(val y: Int, val color: String, val height: Int, val outline: String, val text: String, val width: Int, val x: Int)
@Serializable
data class MemegenGenerateRequest(val bottom_text: String, val font: String, val id: String, val max_font_size: String, val top_text: String)
@Serializable
data class MemegenGenerateResponse(val url: String)
@Serializable
data class MemegenTemplate(val name: String, val url: String, val width: Int, val box_count: Int, val height: Int, val id: String)
@Serializable
data class MemegenTemplatesRequest()
@Serializable
data class MemegenTemplatesResponse(val templates: List<MemegenTemplate>)
