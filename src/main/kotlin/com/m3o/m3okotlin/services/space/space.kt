
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
    suspend fun create(name: String): SpaceCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = SpaceCreateRequest(name)
        }
    }
    suspend fun delete(name: String): SpaceDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = SpaceDeleteRequest(name)
        }
    }
    suspend fun download(name: String): SpaceDownloadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Download")) {
          body = SpaceDownloadRequest(name)
        }
    }
    suspend fun head(name: String): SpaceHeadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Head")) {
          body = SpaceHeadRequest(name)
        }
    }
    suspend fun list(name: String): SpaceListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = SpaceListRequest(name)
        }
    }
    suspend fun read(name: String): SpaceReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = SpaceReadRequest(name)
        }
    }
    suspend fun update(name: String): SpaceUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = SpaceUpdateRequest(name)
        }
    }
    suspend fun upload(name: String): SpaceUploadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Upload")) {
          body = SpaceUploadRequest(name)
        }
    }
}
@Serializable
internal data class SpaceCreateRequest(val name: String, val object: String, val visibility: String)
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
internal data class SpaceSpaceObject(val url: String, val visibility: String, val created: String, val data: String, val modified: String, val name: String)
@Serializable
internal data class SpaceUpdateRequest(val name: String, val object: String, val visibility: String)
@Serializable
data class SpaceUpdateResponse(val url: String)
@Serializable
internal data class SpaceUploadRequest(val name: String, val visibility: String)
@Serializable
data class SpaceUploadResponse(val url: String)
