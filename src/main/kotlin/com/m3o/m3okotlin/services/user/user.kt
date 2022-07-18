
package com.m3o.m3okotlin.services.user

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "user"

object UserServ {
      suspend fun create(req: UserCreateRequest): UserCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = req
        }
      }
      suspend fun delete(req: UserDeleteRequest){
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
      suspend fun logoutAll(req: UserLogoutAllRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "LogoutAll")) {
          body = req
        }
      }
      suspend fun logout(req: UserLogoutRequest){
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
      suspend fun resetPassword(req: UserResetPasswordRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "ResetPassword")) {
          body = req
        }
      }
      suspend fun sendMagicLink(req: UserSendMagicLinkRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "SendMagicLink")) {
          body = req
        }
      }
      suspend fun sendPasswordResetEmail(req: UserSendPasswordResetEmailRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "SendPasswordResetEmail")) {
          body = req
        }
      }
      suspend fun sendVerificationEmail(req: UserSendVerificationEmailRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "SendVerificationEmail")) {
          body = req
        }
      }
      suspend fun updatePassword(req: UserUpdatePasswordRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "UpdatePassword")) {
          body = req
        }
      }
      suspend fun update(req: UserUpdateRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = req
        }
      }
      suspend fun verifyEmail(req: UserVerifyEmailRequest){
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
data class UserAccount(val verified: Boolean? = null, val created: Long? = null, val email: String? = null, val id: String? = null, val profile: Map<String, String>? = null, val updated: Long? = null, val username: String? = null, val verification_date: Long? = null)
@Serializable
data class UserCreateRequest(val profile: Map<String, String>? = null, val username: String? = null, val email: String? = null, val id: String? = null, val password: String? = null)
@Serializable
data class UserCreateResponse(val account: UserAccount? = null)
@Serializable
data class UserDeleteRequest(val id: String? = null)
@Serializable
data class UserListRequest(val limit: Int? = null, val offset: Int? = null)
@Serializable
data class UserListResponse(val users: List<UserAccount>? = null)
@Serializable
data class UserLoginRequest(val password: String? = null, val username: String? = null, val email: String? = null)
@Serializable
data class UserLoginResponse(val session: UserSession? = null)
@Serializable
data class UserLogoutAllRequest(val user_id: String? = null)
@Serializable
data class UserLogoutRequest(val session_id: String? = null)
@Serializable
data class UserReadRequest(val id: String? = null, val username: String? = null, val email: String? = null)
@Serializable
data class UserReadResponse(val account: UserAccount? = null)
@Serializable
data class UserReadSessionRequest(val session_id: String? = null)
@Serializable
data class UserReadSessionResponse(val session: UserSession? = null)
@Serializable
data class UserResetPasswordRequest(val code: String? = null, val confirm_password: String? = null, val email: String? = null, val new_password: String? = null)
@Serializable
data class UserSendMagicLinkRequest(val address: String? = null, val email: String? = null, val endpoint: String? = null, val from_name: String? = null, val subject: String? = null, val text_content: String? = null)
@Serializable
data class UserSendPasswordResetEmailRequest(val from_name: String? = null, val subject: String? = null, val text_content: String? = null, val email: String? = null, val expiration: Long? = null)
@Serializable
data class UserSendVerificationEmailRequest(val from_name: String? = null, val redirect_url: String? = null, val subject: String? = null, val text_content: String? = null, val email: String? = null, val failure_redirect_url: String? = null)
@Serializable
data class UserSession(val created: Long? = null, val expires: Long? = null, val id: String? = null, val userId: String? = null)
@Serializable
data class UserUpdatePasswordRequest(val confirm_password: String? = null, val new_password: String? = null, val old_password: String? = null, val userId: String? = null)
@Serializable
data class UserUpdateRequest(val profile: Map<String, String>? = null, val username: String? = null, val email: String? = null, val id: String? = null)
@Serializable
data class UserVerifyEmailRequest(val token: String? = null)
@Serializable
data class UserVerifyTokenRequest(val token: String? = null)
@Serializable
data class UserVerifyTokenResponse(val message: String? = null, val session: UserSession? = null, val is_valid: Boolean? = null)
