
package com.m3o.m3okotlin.services

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
    suspend fun create(name: String): CommentsCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = CommentsCreateRequest(name)
        }
    }
    suspend fun delete(name: String): CommentsDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = CommentsDeleteRequest(name)
        }
    }
    fun events(name: String, messages: Int = 1, action: (Exception?, CommentsEventsResponse?) -> Unit) {
        val url = getUrl(SERVICE, "Events", true)
        WebSocket(url, Json.encodeToString(CommentsEventsRequest(name, messages))) { e, response ->
            action(e, if (response != null) Json.decodeFromString(response) else null)
        }.connect()
    }
    suspend fun list(name: String): CommentsListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = CommentsListRequest(name)
        }
    }
    suspend fun read(name: String): CommentsReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = CommentsReadRequest(name)
        }
    }
    suspend fun update(name: String): CommentsUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = CommentsUpdateRequest(name)
        }
    }
}
@Serializable
internal data class CommentsComment(val subject: String, val text: String, val updated: String, val created: String, val id: String)
@Serializable
internal data class CommentsCreateRequest(val subject: String, val text: String)
@Serializable
data class CommentsCreateResponse(val comment: CommentsComment)
@Serializable
internal data class CommentsDeleteRequest(val id: String)
@Serializable
data class CommentsDeleteResponse(val comment: CommentsComment)
@Serializable
internal data class CommentsEventsRequest(val id: String)
@Serializable
data class CommentsEventsResponse(val comment: CommentsComment, val event: String)
@Serializable
internal data class CommentsListRequest()
@Serializable
data class CommentsListResponse(val comments: List<CommentsComment>)
@Serializable
internal data class CommentsReadRequest(val id: String)
@Serializable
data class CommentsReadResponse(val comment: CommentsComment)
@Serializable
internal data class CommentsUpdateRequest(val comment: CommentsComment)
@Serializable
data class CommentsUpdateResponse(val comment: CommentsComment)
