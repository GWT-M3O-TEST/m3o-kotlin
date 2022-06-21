
package com.m3o.m3okotlin.services.lists

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient
import com.m3o.m3okotlin.WebSocket

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "lists"

object ListsService {
    suspend fun create(req: ListsCreateRequest): ListsCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = req
        }
    }
}
    suspend fun delete(req: ListsDeleteRequest): ListsDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
    }
}
}
    suspend fun list(): ListsListResponse {
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
    suspend fun read(req: ListsReadRequest): ListsReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = req
        }
    }
}
    suspend fun update(req: ListsUpdateRequest): ListsUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = req
        }
    }
}
