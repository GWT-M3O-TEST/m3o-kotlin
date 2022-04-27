
package com.m3o.m3okotlin.services

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
    suspend fun create(name: String): ListsCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = ListsCreateRequest(name)
        }
    }
    suspend fun delete(name: String): ListsDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = ListsDeleteRequest(name)
        }
    }
    fun events(name: String, messages: Int = 1, action: (Exception?, ListsEventsResponse?) -> Unit) {
        val url = getUrl(SERVICE, "Events", true)
        WebSocket(url, Json.encodeToString(ListsEventsRequest(name, messages))) { e, response ->
            action(e, if (response != null) Json.decodeFromString(response) else null)
        }.connect()
    }
    suspend fun list(name: String): ListsListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = ListsListRequest(name)
        }
    }
    suspend fun read(name: String): ListsReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = ListsReadRequest(name)
        }
    }
    suspend fun update(name: String): ListsUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = ListsUpdateRequest(name)
        }
    }
}
@Serializable
internal data class ListsCreateRequest()
@Serializable
data class ListsCreateResponse()
@Serializable
internal data class ListsDeleteRequest()
@Serializable
data class ListsDeleteResponse()
@Serializable
internal data class ListsEventsRequest()
@Serializable
data class ListsEventsResponse()
@Serializable
internal data class ListsList()
@Serializable
internal data class ListsListRequest()
@Serializable
data class ListsListResponse()
@Serializable
internal data class ListsReadRequest()
@Serializable
data class ListsReadResponse()
@Serializable
internal data class ListsUpdateRequest()
@Serializable
data class ListsUpdateResponse()
