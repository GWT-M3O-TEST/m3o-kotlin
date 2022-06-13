
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "space"

object SpaceService {
    suspend fun create(req: SpaceCreateRequest): SpaceCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = req
        }
    }
    suspend fun delete(req: SpaceDeleteRequest): SpaceDeleteResponse {
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
internal data class SpaceCreateRequest(val object: String, val visibility: String, val name: String)
@Serializable
data class SpaceCreateResponse(val url: String)
@Serializable
internal data class SpaceDeleteRequest(val name: String)
@Serializable
data class SpaceDeleteResponse()
@Serializable
internal data class SpaceDownloadRequest(val name: String)
@Serializable
data class SpaceDownloadResponse(val url: String)
@Serializable
internal data class SpaceHeadObject(val modified: String, val name: String, val url: String, val visibility: String, val created: String)
@Serializable
internal data class SpaceHeadRequest(val name: String)
@Serializable
data class SpaceHeadResponse(val object: SpaceHeadObject)
@Serializable
internal data class SpaceListObject(val created: String, val modified: String, val name: String, val url: String, val visibility: String)
@Serializable
internal data class SpaceListRequest(val prefix: String)
@Serializable
data class SpaceListResponse(val objects: List<SpaceListObject>)
@Serializable
internal data class SpaceReadRequest(val name: String)
@Serializable
data class SpaceReadResponse(val object: SpaceSpaceObject)
@Serializable
internal data class SpaceSpaceObject(val name: String, val url: String, val visibility: String, val created: String, val data: String, val modified: String)
@Serializable
internal data class SpaceUpdateRequest(val name: String, val object: String, val visibility: String)
@Serializable
data class SpaceUpdateResponse(val url: String)
@Serializable
internal data class SpaceUploadRequest(val name: String, val visibility: String)
@Serializable
data class SpaceUploadResponse(val url: String)
