
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "user"

object UserService {
    suspend fun create(name: String): UserCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = UserCreateRequest(name)
        }
    }
    suspend fun delete(name: String): UserDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = UserDeleteRequest(name)
        }
    }
    suspend fun list(name: String): UserListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = UserListRequest(name)
        }
    }
    suspend fun login(name: String): UserLoginResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Login")) {
          body = UserLoginRequest(name)
        }
    }
    suspend fun logoutAll(name: String): UserLogoutAllResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "LogoutAll")) {
          body = UserLogoutAllRequest(name)
        }
    }
    suspend fun logout(name: String): UserLogoutResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Logout")) {
          body = UserLogoutRequest(name)
        }
    }
    suspend fun read(name: String): UserReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = UserReadRequest(name)
        }
    }
    suspend fun readSession(name: String): UserReadSessionResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "ReadSession")) {
          body = UserReadSessionRequest(name)
        }
    }
    suspend fun resetPassword(name: String): UserResetPasswordResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "ResetPassword")) {
          body = UserResetPasswordRequest(name)
        }
    }
    suspend fun sendMagicLink(name: String): UserSendMagicLinkResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "SendMagicLink")) {
          body = UserSendMagicLinkRequest(name)
        }
    }
    suspend fun sendPasswordResetEmail(name: String): UserSendPasswordResetEmailResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "SendPasswordResetEmail")) {
          body = UserSendPasswordResetEmailRequest(name)
        }
    }
    suspend fun sendVerificationEmail(name: String): UserSendVerificationEmailResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "SendVerificationEmail")) {
          body = UserSendVerificationEmailRequest(name)
        }
    }
    suspend fun updatePassword(name: String): UserUpdatePasswordResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "UpdatePassword")) {
          body = UserUpdatePasswordRequest(name)
        }
    }
    suspend fun update(name: String): UserUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = UserUpdateRequest(name)
        }
    }
    suspend fun verifyEmail(name: String): UserVerifyEmailResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "VerifyEmail")) {
          body = UserVerifyEmailRequest(name)
        }
    }
    suspend fun verifyToken(name: String): UserVerifyTokenResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "VerifyToken")) {
          body = UserVerifyTokenRequest(name)
        }
    }
}
@Serializable
internal data class UserAccount(val updated: Long, val username: String, val verification_date: Long, val verified: Boolean, val created: Long, val email: String, val id: String, val profile: Map<String, String>)
@Serializable
internal data class UserCreateRequest(val email: String, val id: String, val password: String, val profile: Map<String, String>, val username: String)
@Serializable
data class UserCreateResponse(val account: UserAccount)
@Serializable
internal data class UserDeleteRequest(val id: String)
@Serializable
data class UserDeleteResponse()
@Serializable
internal data class UserListRequest(val limit: Int, val offset: Int)
@Serializable
data class UserListResponse(val users: List<UserAccount>)
@Serializable
internal data class UserLoginRequest(val email: String, val password: String, val username: String)
@Serializable
data class UserLoginResponse(val session: UserSession)
@Serializable
internal data class UserLogoutAllRequest(val user_id: String)
@Serializable
data class UserLogoutAllResponse()
@Serializable
internal data class UserLogoutRequest(val session_id: String)
@Serializable
data class UserLogoutResponse()
@Serializable
internal data class UserReadRequest(val email: String, val id: String, val username: String)
@Serializable
data class UserReadResponse(val account: UserAccount)
@Serializable
internal data class UserReadSessionRequest(val session_id: String)
@Serializable
data class UserReadSessionResponse(val session: UserSession)
@Serializable
internal data class UserResetPasswordRequest(val confirm_password: String, val email: String, val new_password: String, val code: String)
@Serializable
data class UserResetPasswordResponse()
@Serializable
internal data class UserSendMagicLinkRequest(val subject: String, val text_content: String, val address: String, val email: String, val endpoint: String, val from_name: String)
@Serializable
data class UserSendMagicLinkResponse()
@Serializable
internal data class UserSendPasswordResetEmailRequest(val from_name: String, val subject: String, val text_content: String, val email: String, val expiration: Long)
@Serializable
data class UserSendPasswordResetEmailResponse()
@Serializable
internal data class UserSendVerificationEmailRequest(val from_name: String, val redirect_url: String, val subject: String, val text_content: String, val email: String, val failure_redirect_url: String)
@Serializable
data class UserSendVerificationEmailResponse()
@Serializable
internal data class UserSession(val expires: Long, val id: String, val userId: String, val created: Long)
@Serializable
internal data class UserUpdatePasswordRequest(val confirm_password: String, val new_password: String, val old_password: String, val userId: String)
@Serializable
data class UserUpdatePasswordResponse()
@Serializable
internal data class UserUpdateRequest(val id: String, val profile: Map<String, String>, val username: String, val email: String)
@Serializable
data class UserUpdateResponse()
@Serializable
internal data class UserVerifyEmailRequest(val token: String)
@Serializable
data class UserVerifyEmailResponse()
@Serializable
internal data class UserVerifyTokenRequest(val token: String)
@Serializable
data class UserVerifyTokenResponse(val session: UserSession, val is_valid: Boolean, val message: String)
