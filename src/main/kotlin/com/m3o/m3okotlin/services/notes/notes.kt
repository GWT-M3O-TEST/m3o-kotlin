
package com.m3o.m3okotlin.services.notes

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient
import com.m3o.m3okotlin.WebSocket

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "notes"

object NotesServ {
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
      suspend fun list(): NotesListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) 
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
data class NotesCreateRequest(val text: String? = null, val title: String? = null)
@Serializable
data class NotesCreateResponse(val note: NotesNote? = null)
@Serializable
data class NotesDeleteRequest(val id: String? = null)
@Serializable
data class NotesDeleteResponse(val note: NotesNote? = null)
@Serializable
data class NotesEventsRequest(val id: String? = null)
@Serializable
data class NotesEventsResponse(val event: String? = null, val note: NotesNote? = null)
@Serializable
data class NotesListResponse(val notes: List<NotesNote>? = null)
@Serializable
data class NotesNote(val updated: String? = null, val created: String? = null, val id: String? = null, val text: String? = null, val title: String? = null)
@Serializable
data class NotesReadRequest(val id: String? = null)
@Serializable
data class NotesReadResponse(val note: NotesNote? = null)
@Serializable
data class NotesUpdateRequest(val note: NotesNote? = null)
@Serializable
data class NotesUpdateResponse(val note: NotesNote? = null)
