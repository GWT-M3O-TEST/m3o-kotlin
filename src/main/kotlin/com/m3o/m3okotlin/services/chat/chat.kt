
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
}
    suspend fun delete(req: ChatDeleteRequest): ChatDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
    }
}
    suspend fun history(req: ChatHistoryRequest): ChatHistoryResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "History")) {
          body = req
        }
    }
}
    suspend fun invite(req: ChatInviteRequest): ChatInviteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Invite")) {
          body = req
        }
    }
}
}
    suspend fun kick(req: ChatKickRequest): ChatKickResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Kick")) {
          body = req
        }
    }
}
    suspend fun leave(req: ChatLeaveRequest): ChatLeaveResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Leave")) {
          body = req
        }
    }
}
    suspend fun list(req: ChatListRequest): ChatListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = req
        }
    }
}
    suspend fun send(req: ChatSendRequest): ChatSendResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Send")) {
          body = req
        }
    }
}
