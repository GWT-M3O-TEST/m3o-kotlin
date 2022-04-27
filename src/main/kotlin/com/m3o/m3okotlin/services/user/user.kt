
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
internal data class UserAccount()
@Serializable
internal data class UserCreateRequest()
@Serializable
data class UserCreateResponse()
@Serializable
internal data class UserDeleteRequest()
@Serializable
data class UserDeleteResponse()
@Serializable
internal data class UserListRequest()
@Serializable
data class UserListResponse()
@Serializable
internal data class UserLoginRequest()
@Serializable
data class UserLoginResponse()
@Serializable
internal data class UserLogoutAllRequest()
@Serializable
data class UserLogoutAllResponse()
@Serializable
internal data class UserLogoutRequest()
@Serializable
data class UserLogoutResponse()
@Serializable
internal data class UserReadRequest()
@Serializable
data class UserReadResponse()
@Serializable
internal data class UserReadSessionRequest()
@Serializable
data class UserReadSessionResponse()
@Serializable
internal data class UserResetPasswordRequest()
@Serializable
data class UserResetPasswordResponse()
@Serializable
internal data class UserSendMagicLinkRequest()
@Serializable
data class UserSendMagicLinkResponse()
@Serializable
internal data class UserSendPasswordResetEmailRequest()
@Serializable
data class UserSendPasswordResetEmailResponse()
@Serializable
internal data class UserSendVerificationEmailRequest()
@Serializable
data class UserSendVerificationEmailResponse()
@Serializable
internal data class UserSession()
@Serializable
internal data class UserUpdatePasswordRequest()
@Serializable
data class UserUpdatePasswordResponse()
@Serializable
internal data class UserUpdateRequest()
@Serializable
data class UserUpdateResponse()
@Serializable
internal data class UserVerifyEmailRequest()
@Serializable
data class UserVerifyEmailResponse()
@Serializable
internal data class UserVerifyTokenRequest()
@Serializable
data class UserVerifyTokenResponse()
