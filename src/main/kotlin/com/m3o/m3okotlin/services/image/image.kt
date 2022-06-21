
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
}
    suspend fun delete(req: ImageDeleteRequest){
      return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
        body = req
      }
    }
}
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
    suspend fun resize(req: ImageResizeRequest): ImageResizeResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Resize")) {
          body = req
        }
    }
}
    suspend fun upload(req: ImageUploadRequest): ImageUploadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Upload")) {
          body = req
        }
    }
}
