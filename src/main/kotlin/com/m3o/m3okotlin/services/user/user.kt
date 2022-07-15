
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
data class UserAccount(val created: Long, val email: String, val id: String, val profile: Map<String, String>, val updated: Long, val username: String, val verification_date: Long, val verified: Boolean)
@Serializable
data class UserCreateRequest(val email: String, val id: String, val password: String, val profile: Map<String, String>, val username: String)
@Serializable
data class UserCreateResponse(val account: UserAccount)
@Serializable
data class UserDeleteRequest(val id: String)
@Serializable
data class UserListRequest(val limit: Int, val offset: Int)
@Serializable
data class UserListResponse(val users: List<UserAccount>)
@Serializable
data class UserLoginRequest(val password: String, val username: String, val email: String)
@Serializable
data class UserLoginResponse(val session: UserSession)
@Serializable
data class UserLogoutAllRequest(val user_id: String)
@Serializable
data class UserLogoutRequest(val session_id: String)
@Serializable
data class UserReadRequest(val id: String, val username: String, val email: String)
@Serializable
data class UserReadResponse(val account: UserAccount)
@Serializable
data class UserReadSessionRequest(val session_id: String)
@Serializable
data class UserReadSessionResponse(val session: UserSession)
@Serializable
data class UserResetPasswordRequest(val code: String, val confirm_password: String, val email: String, val new_password: String)
@Serializable
data class UserSendMagicLinkRequest(val from_name: String, val subject: String, val text_content: String, val address: String, val email: String, val endpoint: String)
@Serializable
data class UserSendPasswordResetEmailRequest(val email: String, val expiration: Long, val from_name: String, val subject: String, val text_content: String)
@Serializable
data class UserSendVerificationEmailRequest(val redirect_url: String, val subject: String, val text_content: String, val email: String, val failure_redirect_url: String, val from_name: String)
@Serializable
data class UserSession(val userId: String, val created: Long, val expires: Long, val id: String)
@Serializable
data class UserUpdatePasswordRequest(val confirm_password: String, val new_password: String, val old_password: String, val userId: String)
@Serializable
data class UserUpdateRequest(val id: String, val profile: Map<String, String>, val username: String, val email: String)
@Serializable
data class UserVerifyEmailRequest(val token: String)
@Serializable
data class UserVerifyTokenRequest(val token: String)
@Serializable
data class UserVerifyTokenResponse(val message: String, val session: UserSession, val is_valid: Boolean)
