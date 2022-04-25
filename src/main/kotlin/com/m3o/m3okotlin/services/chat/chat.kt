
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
internal data class ChatCreateRequest({/// chat description
String? description, /// name of the room
String? name, /// whether its a private room
bool? private, /// optional list of user ids
List<String>? user_ids,})
@Serializable
data class ChatCreateResponse({/// the unique chat room
Room? room,})
@Serializable
internal data class ChatDeleteRequest({/// the chat room id to delete
String? room_id,})
@Serializable
data class ChatDeleteResponse({Room? room,})
@Serializable
internal data class ChatHistoryRequest({/// the chat room id to get
String? room_id,})
@Serializable
data class ChatHistoryResponse({/// messages in the chat room
List<Message>? messages,})
@Serializable
internal data class ChatInviteRequest({/// the room id
String? room_id, /// the user id
String? user_id,})
@Serializable
data class ChatInviteResponse({Room? room,})
@Serializable
internal data class ChatJoinRequest({/// chat room to join
String? room_id, /// user id joining
String? user_id,})
@Serializable
data class ChatJoinResponse({Message? message,})
@Serializable
internal data class ChatKickRequest({/// the chat room id
String? room_id, /// the user id
String? user_id,})
@Serializable
data class ChatKickResponse({Room? room,})
@Serializable
internal data class ChatLeaveRequest({/// the chat room id
String? room_id, /// the user id
String? user_id,})
@Serializable
data class ChatLeaveResponse({Room? room,})
@Serializable
internal data class ChatListRequest({/// optional user id to filter by
String? user_id,})
@Serializable
data class ChatListResponse({List<Room>? rooms,})
@Serializable
internal data class ChatMessage({/// a client side id, should be validated by the server to make the request retry safe
String? client, /// id of the message, allocated by the server
String? id, /// id of the chat the message is being sent to / from
String? room_id, /// time the message was sent in RFC3339 format
String? sent_at, /// subject of the message
String? subject, /// text of the message
String? text, /// id of the user who sent the message
String? user_id,})
@Serializable
internal data class ChatRoom({/// description of the that
String? description, /// unique room id
String? id, /// name of the chat
String? name, /// whether its a private room
bool? private, /// list of users
List<String>? user_ids, /// time of creation
String? created_at,})
@Serializable
internal data class ChatSendRequest({/// text of the message
String? text, /// id of the user who sent the message
String? user_id, /// a client side id, should be validated by the server to make the request retry safe
String? client, /// id of the chat room the message is being sent to / from
String? room_id, /// subject of the message
String? subject,})
@Serializable
data class ChatSendResponse({/// the message which was created
Message? message,})
