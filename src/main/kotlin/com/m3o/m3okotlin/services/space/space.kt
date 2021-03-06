
package com.m3o.m3okotlin.services.space

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "space"

object SpaceServ {
      suspend fun create(req: SpaceCreateRequest): SpaceCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = req
        }
      }
      suspend fun delete(req: SpaceDeleteRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
      }
      suspend fun download(req: SpaceDownloadRequest): SpaceDownloadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Download")) {
          body = req
        }
      }
      suspend fun head(req: SpaceHeadRequest): SpaceHeadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Head")) {
          body = req
        }
      }
      suspend fun list(req: SpaceListRequest): SpaceListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = req
        }
      }
      suspend fun read(req: SpaceReadRequest): SpaceReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = req
        }
      }
      suspend fun update(req: SpaceUpdateRequest): SpaceUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = req
        }
      }
      suspend fun upload(req: SpaceUploadRequest): SpaceUploadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Upload")) {
          body = req
        }
      }
}
@Serializable
data class SpaceCreateRequest(val name: String? = null, val obj: String? = null, val visibility: String? = null)
@Serializable
data class SpaceCreateResponse(val url: String? = null)
@Serializable
data class SpaceDeleteRequest(val name: String? = null)
@Serializable
data class SpaceDownloadRequest(val name: String? = null)
@Serializable
data class SpaceDownloadResponse(val url: String? = null)
@Serializable
data class SpaceHeadObject(val created: String? = null, val modified: String? = null, val name: String? = null, val url: String? = null, val visibility: String? = null)
@Serializable
data class SpaceHeadRequest(val name: String? = null)
@Serializable
data class SpaceHeadResponse(val obj: SpaceHeadObject? = null)
@Serializable
data class SpaceListObject(val name: String? = null, val url: String? = null, val visibility: String? = null, val created: String? = null, val modified: String? = null)
@Serializable
data class SpaceListRequest(val prefix: String? = null)
@Serializable
data class SpaceListResponse(val objects: List<SpaceListObject>? = null)
@Serializable
data class SpaceReadRequest(val name: String? = null)
@Serializable
data class SpaceReadResponse(val obj: SpaceSpaceObject? = null)
@Serializable
data class SpaceSpaceObject(val created: String? = null, val data: String? = null, val modified: String? = null, val name: String? = null, val url: String? = null, val visibility: String? = null)
@Serializable
data class SpaceUpdateRequest(val name: String? = null, val obj: String? = null, val visibility: String? = null)
@Serializable
data class SpaceUpdateResponse(val url: String? = null)
@Serializable
data class SpaceUploadRequest(val name: String? = null, val visibility: String? = null)
@Serializable
data class SpaceUploadResponse(val url: String? = null)
