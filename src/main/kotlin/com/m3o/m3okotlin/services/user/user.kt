
package com.m3o.m3okotlin.services.user

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "user"

object UserService {
    suspend fun create(req: UserCreateRequest): UserCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = req
        }
    }
    suspend fun delete(req: UserDeleteRequest): UserDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
    }
    suspend fun list(req: UserListRequest): UserListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = req
        }
    }
    suspend fun login(req: UserLoginRequest): UserLoginResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Login")) {
          body = req
        }
    }
    suspend fun logoutAll(req: UserLogoutAllRequest): UserLogoutAllResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "LogoutAll")) {
          body = req
        }
    }
    suspend fun logout(req: UserLogoutRequest): UserLogoutResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Logout")) {
          body = req
        }
    }
    suspend fun read(req: UserReadRequest): UserReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = req
        }
    }
    suspend fun readSession(req: UserReadSessionRequest): UserReadSessionResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "ReadSession")) {
          body = req
        }
    }
    suspend fun resetPassword(req: UserResetPasswordRequest): UserResetPasswordResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "ResetPassword")) {
          body = req
        }
    }
    suspend fun sendMagicLink(req: UserSendMagicLinkRequest): UserSendMagicLinkResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "SendMagicLink")) {
          body = req
        }
    }
    suspend fun sendPasswordResetEmail(req: UserSendPasswordResetEmailRequest): UserSendPasswordResetEmailResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "SendPasswordResetEmail")) {
          body = req
        }
    }
    suspend fun sendVerificationEmail(req: UserSendVerificationEmailRequest): UserSendVerificationEmailResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "SendVerificationEmail")) {
          body = req
        }
    }
    suspend fun updatePassword(req: UserUpdatePasswordRequest): UserUpdatePasswordResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "UpdatePassword")) {
          body = req
        }
    }
    suspend fun update(req: UserUpdateRequest): UserUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = req
        }
    }
    suspend fun verifyEmail(req: UserVerifyEmailRequest): UserVerifyEmailResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "VerifyEmail")) {
          body = req
        }
    }
    suspend fun verifyToken(req: UserVerifyTokenRequest): UserVerifyTokenResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "VerifyToken")) {
          body = req
        }
    }
}
@Serializable
data class UserAccount(val verified: Boolean, val created: Long, val email: String, val id: String, val profile: Map<String, String>, val updated: Long, val username: String, val verification_date: Long)
@Serializable
data class UserCreateRequest(val email: String, val id: String, val password: String, val profile: Map<String, String>, val username: String)
@Serializable
data class UserCreateResponse(val account: UserAccount)
@Serializable
data class UserDeleteRequest(val id: String)
@Serializable
data class UserDeleteResponse()
@Serializable
data class UserListRequest(val offset: Int, val limit: Int)
@Serializable
data class UserListResponse(val users: List<UserAccount>)
@Serializable
data class UserLoginRequest(val email: String, val password: String, val username: String)
@Serializable
data class UserLoginResponse(val session: UserSession)
@Serializable
data class UserLogoutAllRequest(val user_id: String)
@Serializable
data class UserLogoutAllResponse()
@Serializable
data class UserLogoutRequest(val session_id: String)
@Serializable
data class UserLogoutResponse()
@Serializable
data class UserReadRequest(val email: String, val id: String, val username: String)
@Serializable
data class UserReadResponse(val account: UserAccount)
@Serializable
data class UserReadSessionRequest(val session_id: String)
@Serializable
data class UserReadSessionResponse(val session: UserSession)
@Serializable
data class UserResetPasswordRequest(val code: String, val confirm_password: String, val email: String, val new_password: String)
@Serializable
data class UserResetPasswordResponse()
@Serializable
data class UserSendMagicLinkRequest(val address: String, val email: String, val endpoint: String, val from_name: String, val subject: String, val text_content: String)
@Serializable
data class UserSendMagicLinkResponse()
@Serializable
data class UserSendPasswordResetEmailRequest(val from_name: String, val subject: String, val text_content: String, val email: String, val expiration: Long)
@Serializable
data class UserSendPasswordResetEmailResponse()
@Serializable
data class UserSendVerificationEmailRequest(val email: String, val failure_redirect_url: String, val from_name: String, val redirect_url: String, val subject: String, val text_content: String)
@Serializable
data class UserSendVerificationEmailResponse()
@Serializable
data class UserSession(val created: Long, val expires: Long, val id: String, val userId: String)
@Serializable
data class UserUpdatePasswordRequest(val confirm_password: String, val new_password: String, val old_password: String, val userId: String)
@Serializable
data class UserUpdatePasswordResponse()
@Serializable
data class UserUpdateRequest(val profile: Map<String, String>, val username: String, val email: String, val id: String)
@Serializable
data class UserUpdateResponse()
@Serializable
data class UserVerifyEmailRequest(val token: String)
@Serializable
data class UserVerifyEmailResponse()
@Serializable
data class UserVerifyTokenRequest(val token: String)
@Serializable
data class UserVerifyTokenResponse(val is_valid: Boolean, val message: String, val session: UserSession)
