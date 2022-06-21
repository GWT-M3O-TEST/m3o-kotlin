
package com.m3o.m3okotlin.services.comments

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient
import com.m3o.m3okotlin.WebSocket

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "comments"

object CommentsService {
    suspend fun create(req: CommentsCreateRequest): CommentsCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = req
        }
    }
}
    suspend fun delete(req: CommentsDeleteRequest): CommentsDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
    }
}
}
    suspend fun list(): CommentsListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) 
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
    suspend fun read(req: CommentsReadRequest): CommentsReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = req
        }
    }
}
    suspend fun update(req: CommentsUpdateRequest): CommentsUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = req
        }
    }
}
