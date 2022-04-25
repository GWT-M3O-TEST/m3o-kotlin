
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
internal data class UserAccount({/// unix timestamp

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? updated
	, /// alphanumeric username
String? username, /// date of verification

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? verification_date
	, /// if the account is verified
bool? verified, /// unix timestamp

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? created
	, /// an email address
String? email, /// unique account id
String? id, /// Store any custom data you want about your users in this fields.
Map<String, String>? profile,})
@Serializable
internal data class UserCreateRequest({/// optional user profile as map<string,string>
Map<String, String>? profile, /// the username
String? username, /// the email address
String? email, /// optional account id
String? id, /// the user password
String? password,})
@Serializable
data class UserCreateResponse({Account? account,})
@Serializable
internal data class UserDeleteRequest({/// the account id
String? id,})
@Serializable
data class UserDeleteResponse()
@Serializable
internal data class UserListRequest({/// Maximum number of records to return. Default limit is 25.
/// Maximum limit is 1000. Anything higher will return an error.
int? limit, int? offset,})
@Serializable
data class UserListResponse({List<Account>? users,})
@Serializable
internal data class UserLoginRequest({/// The email address of the user
String? email, /// The password of the user
String? password, /// The username of the user
String? username,})
@Serializable
data class UserLoginResponse({/// The session of the logged in  user
Session? session,})
@Serializable
internal data class UserLogoutAllRequest({/// the user to logout
String? user_id,})
@Serializable
data class UserLogoutAllResponse()
@Serializable
internal data class UserLogoutRequest({/// the session id for the user to logout
String? session_id,})
@Serializable
data class UserLogoutResponse()
@Serializable
internal data class UserReadRequest({/// the account email
String? email, /// the account id
String? id, /// the account username
String? username,})
@Serializable
data class UserReadResponse({Account? account,})
@Serializable
internal data class UserReadSessionRequest({/// The unique session id
String? session_id,})
@Serializable
data class UserReadSessionResponse({/// the session for the user
Session? session,})
@Serializable
internal data class UserResetPasswordRequest({/// The code from the verification email
String? code, /// confirm new password
String? confirm_password, /// the email to reset the password for
String? email, /// the new password
String? new_password,})
@Serializable
data class UserResetPasswordResponse()
@Serializable
internal data class UserSendMagicLinkRequest({/// Endpoint name where your http request handler handles MagicLink by
/// calling M3O VerifyToken endpoint. You can return as a result a success,
/// failed or redirect to another page.
String? endpoint, /// Display name of the sender for the email. Note: the email address will still be 'support@m3o.com'
String? from_name, String? subject, /// Text content of the email. Don't forget to include the string '$micro_verification_link' which will be replaced by the real verification link
/// HTML emails are not available currently.
String? text_content, /// Your web site address, example www.example.com or user.example.com
String? address, /// the email address of the user
String? email,})
@Serializable
data class UserSendMagicLinkResponse()
@Serializable
internal data class UserSendPasswordResetEmailRequest({/// Number of secs that the password reset email is valid for, defaults to 1800 secs (30 mins)

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? expiration
	, /// Display name of the sender for the email. Note: the email address will still be 'noreply@email.m3ocontent.com'
String? from_name, /// subject of the email
String? subject, /// Text content of the email. Don't forget to include the string '$code' which will be replaced by the real verification link
/// HTML emails are not available currently.
String? text_content, /// email address to send reset for
String? email,})
@Serializable
data class UserSendPasswordResetEmailResponse()
@Serializable
internal data class UserSendVerificationEmailRequest({/// Text content of the email. Include '$micro_verification_link' which will be replaced by a verification link
String? text_content, /// email address to send the verification code
String? email, /// The url to redirect to incase of failure
String? failure_redirect_url, /// Display name of the sender for the email. Note: the email address will still be 'noreply@email.m3ocontent.com'
String? from_name, /// The url to redirect to after successful verification
String? redirect_url, /// subject of the email
String? subject,})
@Serializable
data class UserSendVerificationEmailResponse()
@Serializable
internal data class UserSession({/// unix timestamp

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? created
	, /// unix timestamp

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? expires
	, /// the session id
String? id, /// the associated user id
String? userId,})
@Serializable
internal data class UserUpdatePasswordRequest({/// the old password
String? old_password, /// the account id
String? userId, /// confirm new password
String? confirm_password, /// the new password
String? new_password,})
@Serializable
data class UserUpdatePasswordResponse()
@Serializable
internal data class UserUpdateRequest({/// the new email address
String? email, /// the account id
String? id, /// the user profile as map<string,string>
Map<String, String>? profile, /// the new username
String? username,})
@Serializable
data class UserUpdateResponse()
@Serializable
internal data class UserVerifyEmailRequest({/// The token from the verification email
String? token,})
@Serializable
data class UserVerifyEmailResponse()
@Serializable
internal data class UserVerifyTokenRequest({String? token,})
@Serializable
data class UserVerifyTokenResponse({bool? is_valid, String? message, Session? session,})
