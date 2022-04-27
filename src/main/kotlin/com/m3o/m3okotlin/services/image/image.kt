
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "image"

object ImageService {
    suspend fun convert(name: String): ImageConvertResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Convert")) {
          body = ImageConvertRequest(name)
        }
    }
    suspend fun delete(name: String): ImageDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = ImageDeleteRequest(name)
        }
    }
    suspend fun resize(name: String): ImageResizeResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Resize")) {
          body = ImageResizeRequest(name)
        }
    }
    suspend fun upload(name: String): ImageUploadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Upload")) {
          body = ImageUploadRequest(name)
        }
    }
}
@Serializable
internal data class ImageConvertRequest()
@Serializable
data class ImageConvertResponse()
@Serializable
internal data class ImageCropOptions()
@Serializable
internal data class ImageDeleteRequest()
@Serializable
data class ImageDeleteResponse()
@Serializable
internal data class ImagePoint()
@Serializable
internal data class ImageRectangle()
@Serializable
internal data class ImageResizeRequest()
@Serializable
data class ImageResizeResponse()
@Serializable
internal data class ImageUploadRequest()
@Serializable
data class ImageUploadResponse()
