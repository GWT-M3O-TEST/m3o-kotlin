
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
internal data class ImageConvertRequest(val name: String, val outputURL: Boolean, val url: String, val base64: String, val file: String)
@Serializable
data class ImageConvertResponse(val base64: String, val url: String)
@Serializable
internal data class ImageCropOptions(val anchor: String, val height: Int, val width: Int)
@Serializable
internal data class ImageDeleteRequest(val url: String)
@Serializable
data class ImageDeleteResponse()
@Serializable
internal data class ImagePoint(val x: Int, val y: Int)
@Serializable
internal data class ImageRectangle(val min: ImagePoint, val max: ImagePoint)
@Serializable
internal data class ImageResizeRequest(val outputURL: Boolean, val url: String, val width: Long, val base64: String, val cropOptions: ImageCropOptions, val file: String, val height: Long, val name: String)
@Serializable
data class ImageResizeResponse(val base64: String, val url: String)
@Serializable
internal data class ImageUploadRequest(val base64: String, val file: String, val name: String, val url: String)
@Serializable
data class ImageUploadResponse(val url: String)
