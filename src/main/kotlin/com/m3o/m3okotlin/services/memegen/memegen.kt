
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
internal data class MemegenBox({/// y axis position
int? y, /// colour hex code
String? color, /// height in pixels
int? height, /// outline color hex code
String? outline, /// text to display
String? text, /// width in pixels
int? width, /// x axis position
int? x,})
@Serializable
internal data class MemegenGenerateRequest({/// top text
String? top_text, /// bottom text
String? bottom_text, /// font: arial or impact
String? font, /// the template id to use
String? id, /// font size; defaults to 50px
String? max_font_size,})
@Serializable
data class MemegenGenerateResponse({/// url of the memegen
String? url,})
@Serializable
internal data class MemegenTemplate({/// number of boxes used
int? box_count, /// height in pixels
int? height, /// id of the memegen
String? id, /// name of the memegen
String? name, /// url of the memegen
String? url, /// width in pixels
int? width,})
@Serializable
internal data class MemegenTemplatesRequest()
@Serializable
data class MemegenTemplatesResponse({List<Template>? templates,})
