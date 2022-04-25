
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
internal data class ImageConvertRequest({/// The image file to convert
String? file, /// output name of the image including extension, ie. "cat.png"
String? name, /// make output a URL and not a base64 response
bool? outputURL, /// url of the image to resize
String? url, /// base64 encoded image to resize,
String? base64,})
@Serializable
data class ImageConvertResponse({String? base64, String? url,})
@Serializable
internal data class ImageCropOptions({/// Crop anchor point: "top", "top left", "top right",
/// "left", "center", "right"
/// "bottom left", "bottom", "bottom right".
/// Optional. Defaults to center.
String? anchor, /// height to crop to
int? height, /// width to crop to
int? width,})
@Serializable
internal data class ImageDeleteRequest({/// url of the image to delete e.g. https://cdn.m3ocontent.com/micro/images/micro/41e23b39-48dd-42b6-9738-79a313414bb8/cat.jpeg
String? url,})
@Serializable
data class ImageDeleteResponse()
@Serializable
internal data class ImagePoint({int? x, int? y,})
@Serializable
internal data class ImageRectangle({Point? max, Point? min,})
@Serializable
internal data class ImageResizeRequest({/// optional crop options
/// if provided, after resize, the image
/// will be cropped
CropOptions? cropOptions, /// The image file to resize
String? file, 
	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? height
	, /// output name of the image including extension, ie. "cat.png"
String? name, /// make output a URL and not a base64 response
bool? outputURL, /// url of the image to resize
String? url, 
	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? width
	, /// base64 encoded image to resize,
String? base64,})
@Serializable
data class ImageResizeResponse({String? url, String? base64,})
@Serializable
internal data class ImageUploadRequest({/// Base64 encoded image to upload,
String? base64, /// The image file to upload
String? file, /// Output name of the image including extension, ie. "cat.png"
String? name, /// URL of the image to upload
String? url,})
@Serializable
data class ImageUploadResponse({String? url,})
