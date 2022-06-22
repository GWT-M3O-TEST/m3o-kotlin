
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
    suspend fun delete(req: CommentsDeleteRequest): CommentsDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
    }
    fun events(req: CommentsEventsRequest, action: (Exception?, CommentsEventsResponse?) -> Unit) {
        val url = getUrl(SERVICE, "Events", true)
        WebSocket(url, Json.encodeToString(req)) { e, response ->
            action(e, if (response != null) Json.decodeFromString(response) else null)
        }.connect()
    }
    suspend fun list(): CommentsListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) 
    }
    suspend fun read(req: CommentsReadRequest): CommentsReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = req
        }
    }
    suspend fun update(req: CommentsUpdateRequest): CommentsUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = req
        }
    }
}
@Serializable
data class CommentsComment(val updated: String, val created: String, val id: String, val subject: String, val text: String)
@Serializable
data class CommentsCreateRequest(val text: String, val subject: String)
@Serializable
data class CommentsCreateResponse(val comment: CommentsComment)
@Serializable
data class CommentsDeleteRequest(val id: String)
@Serializable
data class CommentsDeleteResponse(val comment: CommentsComment)
@Serializable
data class CommentsEventsRequest(val id: String)
@Serializable
data class CommentsEventsResponse(val comment: CommentsComment, val event: String)
@Serializable
class CommentsListRequest()
@Serializable
data class CommentsListResponse(val comments: List<CommentsComment>)
@Serializable
data class CommentsReadRequest(val id: String)
@Serializable
data class CommentsReadResponse(val comment: CommentsComment)
@Serializable
data class CommentsUpdateRequest(val comment: CommentsComment)
@Serializable
data class CommentsUpdateResponse(val comment: CommentsComment)
