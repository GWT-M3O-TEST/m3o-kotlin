
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
internal data class NotesCreateRequest({/// note text
String? text, /// note title
String? title,})
@Serializable
data class NotesCreateResponse({/// The created note
Note? note,})
@Serializable
internal data class NotesDeleteRequest({/// specify the id of the note
String? id,})
@Serializable
data class NotesDeleteResponse({Note? note,})
@Serializable
internal data class NotesEventsRequest({/// optionally specify a note id
String? id,})
@Serializable
data class NotesEventsResponse({/// the event which occured; create, delete, update
String? event, /// the note which the operation occured on
Note? note,})
@Serializable
internal data class NotesListRequest()
@Serializable
data class NotesListResponse({/// the list of notes
List<Note>? notes,})
@Serializable
internal data class NotesNote({/// unique id for the note, generated if not specified
String? id, /// text within the note
String? text, /// title of the note
String? title, /// time at which the note was updated
String? updated, /// time at which the note was created
String? created,})
@Serializable
internal data class NotesReadRequest({/// the note id
String? id,})
@Serializable
data class NotesReadResponse({/// The note
Note? note,})
@Serializable
internal data class NotesUpdateRequest({Note? note,})
@Serializable
data class NotesUpdateResponse({Note? note,})
