
package com.m3o.m3okotlin.services.notes

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
    suspend fun create(req: NotesCreateRequest): NotesCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = req
        }
    }
    suspend fun delete(req: NotesDeleteRequest): NotesDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
    }
    fun events(req: NotesEventsRequest, action: (Exception?, NotesEventsResponse?) -> Unit) {
        val url = getUrl(SERVICE, "Events", true)
        WebSocket(url, Json.encodeToString(req)) { e, response ->
            action(e, if (response != null) Json.decodeFromString(response) else null)
        }.connect()
    }
    suspend fun list(req: NotesListRequest): NotesListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = req
        }
    }
    suspend fun read(req: NotesReadRequest): NotesReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = req
        }
    }
    suspend fun update(req: NotesUpdateRequest): NotesUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = req
        }
    }
}
@Serializable
data class NotesCreateRequest(val text: String, val title: String)
@Serializable
data class NotesCreateResponse(val note: NotesNote)
@Serializable
data class NotesDeleteRequest(val id: String)
@Serializable
data class NotesDeleteResponse(val note: NotesNote)
@Serializable
data class NotesEventsRequest(val id: String)
@Serializable
data class NotesEventsResponse(val note: NotesNote, val event: String)
@Serializable
data class NotesListRequest()
@Serializable
data class NotesListResponse(val notes: List<NotesNote>)
@Serializable
data class NotesNote(val created: String, val id: String, val text: String, val title: String, val updated: String)
@Serializable
data class NotesReadRequest(val id: String)
@Serializable
data class NotesReadResponse(val note: NotesNote)
@Serializable
data class NotesUpdateRequest(val note: NotesNote)
@Serializable
data class NotesUpdateResponse(val note: NotesNote)
