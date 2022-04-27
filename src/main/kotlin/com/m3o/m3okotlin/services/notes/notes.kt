
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient
import com.m3o.m3okotlin.WebSocket

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "notes"

object NotesService {
    suspend fun create(name: String): NotesCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = NotesCreateRequest(name)
        }
    }
    suspend fun delete(name: String): NotesDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = NotesDeleteRequest(name)
        }
    }
    fun events(name: String, messages: Int = 1, action: (Exception?, NotesEventsResponse?) -> Unit) {
        val url = getUrl(SERVICE, "Events", true)
        WebSocket(url, Json.encodeToString(NotesEventsRequest(name, messages))) { e, response ->
            action(e, if (response != null) Json.decodeFromString(response) else null)
        }.connect()
    }
    suspend fun list(name: String): NotesListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = NotesListRequest(name)
        }
    }
    suspend fun read(name: String): NotesReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = NotesReadRequest(name)
        }
    }
    suspend fun update(name: String): NotesUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = NotesUpdateRequest(name)
        }
    }
}
@Serializable
internal data class NotesCreateRequest(val text: String, val title: String)
@Serializable
data class NotesCreateResponse(val note: NotesNote)
@Serializable
internal data class NotesDeleteRequest(val id: String)
@Serializable
data class NotesDeleteResponse(val note: NotesNote)
@Serializable
internal data class NotesEventsRequest(val id: String)
@Serializable
data class NotesEventsResponse(val event: String, val note: NotesNote)
@Serializable
internal data class NotesListRequest()
@Serializable
data class NotesListResponse(val notes: List<NotesNote>)
@Serializable
internal data class NotesNote(val created: String, val id: String, val text: String, val title: String, val updated: String)
@Serializable
internal data class NotesReadRequest(val id: String)
@Serializable
data class NotesReadResponse(val note: NotesNote)
@Serializable
internal data class NotesUpdateRequest(val note: NotesNote)
@Serializable
data class NotesUpdateResponse(val note: NotesNote)
