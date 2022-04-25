
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "avatar"

object AvatarService {
    suspend fun generate(name: String): AvatarGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
          body = AvatarGenerateRequest(name)
        }
    }
}
@Serializable
internal data class AvatarGenerateRequest({/// encode format of avatar image: `png` or `jpeg`; default is `jpeg`
String? format, /// avatar's gender: `male` or `female`; default is `male`
String? gender, /// set to true to upload to the M3O CDN and receive the url
bool? upload, /// avatar's username, unique username will generate the unique avatar;
/// if empty, every request generates a random avatar;
/// if upload == true, username will be the CDN filename rather than a random uuid string
String? username,})
@Serializable
data class AvatarGenerateResponse({/// base64 encoded string of the avatar image
String? base64, /// M3O's CDN url of the avatar image
String? url,})
