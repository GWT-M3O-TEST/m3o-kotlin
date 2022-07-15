
package com.m3o.m3okotlin.services.chat

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
      suspend fun create(req: ChatCreateRequest): ChatCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = req
        }
      }
      suspend fun delete(req: ChatDeleteRequest): ChatDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
      }
      suspend fun history(req: ChatHistoryRequest): ChatHistoryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "History")) {
          body = req
        }
      }
      suspend fun invite(req: ChatInviteRequest): ChatInviteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Invite")) {
          body = req
        }
      }
      fun join(req: ChatJoinRequest, action: (Exception?, ChatJoinResponse?) -> Unit) {
          val url = getUrl(SERVICE, "Join", true)
          WebSocket(url, Json.encodeToString(req)) { e, response ->
              action(e, if (response != null) Json.decodeFromString(response) else null)
          }.connect()
      }
      suspend fun kick(req: ChatKickRequest): ChatKickResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Kick")) {
          body = req
        }
      }
      suspend fun leave(req: ChatLeaveRequest): ChatLeaveResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Leave")) {
          body = req
        }
      }
      suspend fun list(req: ChatListRequest): ChatListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = req
        }
      }
      suspend fun send(req: ChatSendRequest): ChatSendResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Send")) {
          body = req
        }
      }
}
@Serializable
data class ChatCreateRequest(val description: String, val name: String, val private: Boolean, val user_ids: List<String>)
@Serializable
data class ChatCreateResponse(val room: ChatRoom)
@Serializable
data class ChatDeleteRequest(val room_id: String)
@Serializable
data class ChatDeleteResponse(val room: ChatRoom)
@Serializable
data class ChatHistoryRequest(val room_id: String)
@Serializable
data class ChatHistoryResponse(val messages: List<ChatMessage>)
@Serializable
data class ChatInviteRequest(val room_id: String, val user_id: String)
@Serializable
data class ChatInviteResponse(val room: ChatRoom)
@Serializable
data class ChatJoinRequest(val room_id: String, val user_id: String)
@Serializable
data class ChatJoinResponse(val message: ChatMessage)
@Serializable
data class ChatKickRequest(val room_id: String, val user_id: String)
@Serializable
data class ChatKickResponse(val room: ChatRoom)
@Serializable
data class ChatLeaveRequest(val room_id: String, val user_id: String)
@Serializable
data class ChatLeaveResponse(val room: ChatRoom)
@Serializable
data class ChatListRequest(val user_id: String)
@Serializable
data class ChatListResponse(val rooms: List<ChatRoom>)
@Serializable
data class ChatMessage(val room_id: String, val sent_at: String, val subject: String, val text: String, val user_id: String, val client: String, val id: String)
@Serializable
data class ChatRoom(val created_at: String, val description: String, val id: String, val name: String, val private: Boolean, val user_ids: List<String>)
@Serializable
data class ChatSendRequest(val subject: String, val text: String, val user_id: String, val client: String, val room_id: String)
@Serializable
data class ChatSendResponse(val message: ChatMessage)
