
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
internal data class CommentsComment({/// text of the comment
String? text, /// time at which the comment was updated
String? updated, /// time at which the comment was created
String? created, /// unique id for the comment, generated if not specified
String? id, /// subject of the comment
String? subject,})
@Serializable
internal data class CommentsCreateRequest({/// comment subject
String? subject, /// comment items
String? text,})
@Serializable
data class CommentsCreateResponse({/// The created comment
Comment? comment,})
@Serializable
internal data class CommentsDeleteRequest({/// specify the id of the comment
String? id,})
@Serializable
data class CommentsDeleteResponse({Comment? comment,})
@Serializable
internal data class CommentsEventsRequest({/// optionally specify a comment id
String? id,})
@Serializable
data class CommentsEventsResponse({/// the comment which the operation occured on
Comment? comment, /// the event which occured; create, delete, update
String? event,})
@Serializable
internal data class CommentsListRequest()
@Serializable
data class CommentsListResponse({/// the comment of comments
List<Comment>? comments,})
@Serializable
internal data class CommentsReadRequest({/// the comment id
String? id,})
@Serializable
data class CommentsReadResponse({/// The comment
Comment? comment,})
@Serializable
internal data class CommentsUpdateRequest({Comment? comment,})
@Serializable
data class CommentsUpdateResponse({Comment? comment,})
