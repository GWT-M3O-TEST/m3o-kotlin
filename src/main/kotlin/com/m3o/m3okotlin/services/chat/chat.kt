
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient
import com.m3o.m3okotlin.WebSocket

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "chat"

object ChatService {
    suspend fun create(name: String): ChatCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = ChatCreateRequest(name)
        }
    }
    suspend fun delete(name: String): ChatDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = ChatDeleteRequest(name)
        }
    }
    suspend fun history(name: String): ChatHistoryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "History")) {
          body = ChatHistoryRequest(name)
        }
    }
    suspend fun invite(name: String): ChatInviteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Invite")) {
          body = ChatInviteRequest(name)
        }
    }
    fun join(name: String, messages: Int = 1, action: (Exception?, ChatJoinResponse?) -> Unit) {
        val url = getUrl(SERVICE, "Join", true)
        WebSocket(url, Json.encodeToString(ChatJoinRequest(name, messages))) { e, response ->
            action(e, if (response != null) Json.decodeFromString(response) else null)
        }.connect()
    }
    suspend fun kick(name: String): ChatKickResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Kick")) {
          body = ChatKickRequest(name)
        }
    }
    suspend fun leave(name: String): ChatLeaveResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Leave")) {
          body = ChatLeaveRequest(name)
        }
    }
    suspend fun list(name: String): ChatListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = ChatListRequest(name)
        }
    }
    suspend fun send(name: String): ChatSendResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Send")) {
          body = ChatSendRequest(name)
        }
    }
}
@Serializable
internal data class ChatCreateRequest()
@Serializable
data class ChatCreateResponse()
@Serializable
internal data class ChatDeleteRequest()
@Serializable
data class ChatDeleteResponse()
@Serializable
internal data class ChatHistoryRequest()
@Serializable
data class ChatHistoryResponse()
@Serializable
internal data class ChatInviteRequest()
@Serializable
data class ChatInviteResponse()
@Serializable
internal data class ChatJoinRequest()
@Serializable
data class ChatJoinResponse()
@Serializable
internal data class ChatKickRequest()
@Serializable
data class ChatKickResponse()
@Serializable
internal data class ChatLeaveRequest()
@Serializable
data class ChatLeaveResponse()
@Serializable
internal data class ChatListRequest()
@Serializable
data class ChatListResponse()
@Serializable
internal data class ChatMessage()
@Serializable
internal data class ChatRoom()
@Serializable
internal data class ChatSendRequest()
@Serializable
data class ChatSendResponse()
