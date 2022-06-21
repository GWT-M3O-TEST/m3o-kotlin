
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
}
    suspend fun delete(req: NotesDeleteRequest): NotesDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
    }
}
}
    suspend fun list(): NotesListResponse {
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
    suspend fun read(req: NotesReadRequest): NotesReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = req
        }
    }
}
    suspend fun update(req: NotesUpdateRequest): NotesUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = req
        }
    }
}
