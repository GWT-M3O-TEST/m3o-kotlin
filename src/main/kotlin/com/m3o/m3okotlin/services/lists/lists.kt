
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
internal data class ListsCreateRequest({/// list items
List<String>? items, /// list name
String? name,})
@Serializable
data class ListsCreateResponse({/// The created list
List? list,})
@Serializable
internal data class ListsDeleteRequest({/// specify the id of the list
String? id,})
@Serializable
data class ListsDeleteResponse({List? list,})
@Serializable
internal data class ListsEventsRequest({/// optionally specify a list id
String? id,})
@Serializable
data class ListsEventsResponse({/// the list which the operation occured on
List? list, /// the event which occured; create, delete, update
String? event,})
@Serializable
internal data class ListsList({/// time at which the list was created
String? created, /// unique id for the list, generated if not specified
String? id, /// items within the list
List<String>? items, /// name of the list
String? name, /// time at which the list was updated
String? updated,})
@Serializable
internal data class ListsListRequest()
@Serializable
data class ListsListResponse({/// the list of lists
List<List>? lists,})
@Serializable
internal data class ListsReadRequest({/// the list id
String? id,})
@Serializable
data class ListsReadResponse({/// The list
List? list,})
@Serializable
internal data class ListsUpdateRequest({List? list,})
@Serializable
data class ListsUpdateResponse({List? list,})
