
package com.m3o.m3okotlin.services.lists

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient
import com.m3o.m3okotlin.WebSocket

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "lists"

object ListsServ {
      suspend fun create(req: ListsCreateRequest): ListsCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = req
        }
      }
      suspend fun delete(req: ListsDeleteRequest): ListsDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
      }
      fun events(req: ListsEventsRequest, action: (Exception?, ListsEventsResponse?) -> Unit) {
          val url = getUrl(SERVICE, "Events", true)
          WebSocket(url, Json.encodeToString(req)) { e, response ->
              action(e, if (response != null) Json.decodeFromString(response) else null)
          }.connect()
      }
      suspend fun list(): ListsListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) 
      }
      suspend fun read(req: ListsReadRequest): ListsReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = req
        }
      }
      suspend fun update(req: ListsUpdateRequest): ListsUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = req
        }
      }
}
@Serializable
data class ListsCreateRequest(val items: List<String>? = null, val name: String? = null)
@Serializable
data class ListsCreateResponse(val list: ListsList? = null)
@Serializable
data class ListsDeleteRequest(val id: String? = null)
@Serializable
data class ListsDeleteResponse(val list: ListsList? = null)
@Serializable
data class ListsEventsRequest(val id: String? = null)
@Serializable
data class ListsEventsResponse(val event: String? = null, val list: ListsList? = null)
@Serializable
data class ListsList(val created: String? = null, val id: String? = null, val items: List<String>? = null, val name: String? = null, val updated: String? = null)
@Serializable
data class ListsListResponse(val lists: List<ListsList>? = null)
@Serializable
data class ListsReadRequest(val id: String? = null)
@Serializable
data class ListsReadResponse(val list: ListsList? = null)
@Serializable
data class ListsUpdateRequest(val list: ListsList? = null)
@Serializable
data class ListsUpdateResponse(val list: ListsList? = null)
