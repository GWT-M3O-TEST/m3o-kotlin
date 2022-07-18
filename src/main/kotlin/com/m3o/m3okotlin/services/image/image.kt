
package com.m3o.m3okotlin.services.image

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "image"

object ImageServ {
      suspend fun convert(req: ImageConvertRequest): ImageConvertResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Convert")) {
          body = req
        }
      }
      suspend fun delete(req: ImageDeleteRequest){
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
data class ImageConvertRequest(val base64: String? = null, val file: String? = null, val name: String? = null, val outputURL: Boolean? = null, val url: String? = null)
@Serializable
data class ImageConvertResponse(val url: String? = null, val base64: String? = null)
@Serializable
data class ImageCropOptions(val anchor: String? = null, val height: Int? = null, val width: Int? = null)
@Serializable
data class ImageDeleteRequest(val url: String? = null)
@Serializable
data class ImagePoint(val x: Int? = null, val y: Int? = null)
@Serializable
data class ImageRectangle(val min: ImagePoint? = null, val max: ImagePoint? = null)
@Serializable
data class ImageResizeRequest(val url: String? = null, val width: Long? = null, val base64: String? = null, val cropOptions: ImageCropOptions? = null, val file: String? = null, val height: Long? = null, val name: String? = null, val outputURL: Boolean? = null)
@Serializable
data class ImageResizeResponse(val base64: String? = null, val url: String? = null)
@Serializable
data class ImageUploadRequest(val base64: String? = null, val file: String? = null, val name: String? = null, val url: String? = null)
@Serializable
data class ImageUploadResponse(val url: String? = null)
