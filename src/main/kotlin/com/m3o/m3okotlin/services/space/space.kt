
package com.m3o.m3okotlin.services.space

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
}
    suspend fun delete(req: SpaceDeleteRequest){
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
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
    suspend fun download(req: SpaceDownloadRequest): SpaceDownloadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Download")) {
          body = req
        }
    }
}
    suspend fun head(req: SpaceHeadRequest): SpaceHeadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Head")) {
          body = req
        }
    }
}
    suspend fun list(req: SpaceListRequest): SpaceListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = req
        }
    }
}
    suspend fun read(req: SpaceReadRequest): SpaceReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = req
        }
    }
}
    suspend fun update(req: SpaceUpdateRequest): SpaceUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = req
        }
    }
}
    suspend fun upload(req: SpaceUploadRequest): SpaceUploadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Upload")) {
          body = req
        }
    }
}
