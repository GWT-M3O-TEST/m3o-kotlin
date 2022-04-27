
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
internal data class ChatCreateRequest(val description: String, val name: String, val private: Boolean, val user_ids: List<ChatString>)
@Serializable
data class ChatCreateResponse(val room: ChatRoom)
@Serializable
internal data class ChatDeleteRequest(val room_id: String)
@Serializable
data class ChatDeleteResponse(val room: ChatRoom)
@Serializable
internal data class ChatHistoryRequest(val room_id: String)
@Serializable
data class ChatHistoryResponse(val messages: List<ChatMessage>)
@Serializable
internal data class ChatInviteRequest(val room_id: String, val user_id: String)
@Serializable
data class ChatInviteResponse(val room: ChatRoom)
@Serializable
internal data class ChatJoinRequest(val room_id: String, val user_id: String)
@Serializable
data class ChatJoinResponse(val message: ChatMessage)
@Serializable
internal data class ChatKickRequest(val room_id: String, val user_id: String)
@Serializable
data class ChatKickResponse(val room: ChatRoom)
@Serializable
internal data class ChatLeaveRequest(val room_id: String, val user_id: String)
@Serializable
data class ChatLeaveResponse(val room: ChatRoom)
@Serializable
internal data class ChatListRequest(val user_id: String)
@Serializable
data class ChatListResponse(val rooms: List<ChatRoom>)
@Serializable
internal data class ChatMessage(val id: String, val room_id: String, val sent_at: String, val subject: String, val text: String, val user_id: String, val client: String)
@Serializable
internal data class ChatRoom(val name: String, val private: Boolean, val user_ids: List<ChatString>, val created_at: String, val description: String, val id: String)
@Serializable
internal data class ChatSendRequest(val client: String, val room_id: String, val subject: String, val text: String, val user_id: String)
@Serializable
data class ChatSendResponse(val message: ChatMessage)
