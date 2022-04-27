
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
internal data class SpaceCreateRequest()
@Serializable
data class SpaceCreateResponse()
@Serializable
internal data class SpaceDeleteRequest()
@Serializable
data class SpaceDeleteResponse()
@Serializable
internal data class SpaceDownloadRequest()
@Serializable
data class SpaceDownloadResponse()
@Serializable
internal data class SpaceHeadObject()
@Serializable
internal data class SpaceHeadRequest()
@Serializable
data class SpaceHeadResponse()
@Serializable
internal data class SpaceListObject()
@Serializable
internal data class SpaceListRequest()
@Serializable
data class SpaceListResponse()
@Serializable
internal data class SpaceReadRequest()
@Serializable
data class SpaceReadResponse()
@Serializable
internal data class SpaceSpaceObject()
@Serializable
internal data class SpaceUpdateRequest()
@Serializable
data class SpaceUpdateResponse()
@Serializable
internal data class SpaceUploadRequest()
@Serializable
data class SpaceUploadResponse()
