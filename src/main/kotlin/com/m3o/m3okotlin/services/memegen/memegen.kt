
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "memegen"

object MemegenService {
    suspend fun generate(name: String): MemegenGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
          body = MemegenGenerateRequest(name)
        }
    }
    suspend fun templates(name: String): MemegenTemplatesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Templates")) {
          body = MemegenTemplatesRequest(name)
        }
    }
}
@Serializable
internal data class MemegenBox(val x: Int, val y: Int, val color: String, val height: Int, val outline: String, val text: String, val width: Int)
@Serializable
internal data class MemegenGenerateRequest(val font: String, val id: String, val max_font_size: String, val top_text: String, val bottom_text: String)
@Serializable
data class MemegenGenerateResponse(val url: String)
@Serializable
internal data class MemegenTemplate(val box_count: Int, val height: Int, val id: String, val name: String, val url: String, val width: Int)
@Serializable
internal data class MemegenTemplatesRequest()
@Serializable
data class MemegenTemplatesResponse(val templates: List<MemegenTemplate>)
