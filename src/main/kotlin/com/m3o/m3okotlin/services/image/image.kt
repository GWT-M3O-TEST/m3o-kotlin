
package com.m3o.m3okotlin.services.image

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "image"

object ImageService {
    suspend fun convert(req: ImageConvertRequest): ImageConvertResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Convert")) {
          body = req
        }
    }
    suspend fun delete(req: ImageDeleteRequest): ImageDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
    }
    suspend fun resize(req: ImageResizeRequest): ImageResizeResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Resize")) {
          body = req
        }
    }
    suspend fun upload(req: ImageUploadRequest): ImageUploadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Upload")) {
          body = req
        }
    }
}
@Serializable
data class ImageConvertRequest(val outputURL: Boolean, val url: String, val base64: String, val file: String, val name: String)
@Serializable
data class ImageConvertResponse(val base64: String, val url: String)
@Serializable
data class ImageCropOptions(val height: Int, val width: Int, val anchor: String)
@Serializable
data class ImageDeleteRequest(val url: String)
@Serializable
data class ImageDeleteResponse()
@Serializable
data class ImagePoint(val x: Int, val y: Int)
@Serializable
data class ImageRectangle(val max: ImagePoint, val min: ImagePoint)
@Serializable
data class ImageResizeRequest(val base64: String, val cropOptions: ImageCropOptions, val file: String, val height: Long, val name: String, val outputURL: Boolean, val url: String, val width: Long)
@Serializable
data class ImageResizeResponse(val base64: String, val url: String)
@Serializable
data class ImageUploadRequest(val url: String, val base64: String, val file: String, val name: String)
@Serializable
data class ImageUploadResponse(val url: String)
