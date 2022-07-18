
package com.m3o.m3okotlin.services.contact

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "contact"

object ContactServ {
      suspend fun create(req: ContactCreateRequest): ContactCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = req
        }
      }
      suspend fun delete(req: ContactDeleteRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
      }
      suspend fun list(req: ContactListRequest): ContactListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = req
        }
      }
      suspend fun read(req: ContactReadRequest): ContactReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = req
        }
      }
      suspend fun update(req: ContactUpdateRequest): ContactUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = req
        }
      }
}
@Serializable
data class ContactAddress(val label: String? = null, val location: String? = null)
@Serializable
data class ContactContactInfo(val addresses: List<ContactAddress>? = null, val created_at: String? = null, val emails: List<ContactEmail>? = null, val id: String? = null, val links: List<ContactLink>? = null, val note: String? = null, val phones: List<ContactPhone>? = null, val social_medias: List<ContactSocialMedia>? = null, val birthday: String? = null, val name: String? = null, val updated_at: String? = null)
@Serializable
data class ContactCreateRequest(val addresses: List<ContactAddress>? = null, val birthday: String? = null, val emails: List<ContactEmail>? = null, val links: List<ContactLink>? = null, val name: String? = null, val note: String? = null, val phones: List<ContactPhone>? = null, val social_medias: List<ContactSocialMedia>? = null)
@Serializable
data class ContactCreateResponse(val contact: ContactContactInfo? = null)
@Serializable
data class ContactDeleteRequest(val id: String? = null)
@Serializable
data class ContactEmail(val address: String? = null, val label: String? = null)
@Serializable
data class ContactLink(val label: String? = null, val url: String? = null)
@Serializable
data class ContactListRequest(val limit: Int? = null, val offset: Int? = null)
@Serializable
data class ContactListResponse(val contacts: List<ContactContactInfo>? = null)
@Serializable
data class ContactPhone(val label: String? = null, val number: String? = null)
@Serializable
data class ContactReadRequest(val id: String? = null)
@Serializable
data class ContactReadResponse(val contact: ContactContactInfo? = null)
@Serializable
data class ContactSocialMedia(val label: String? = null, val username: String? = null)
@Serializable
data class ContactUpdateRequest(val name: String? = null, val note: String? = null, val phones: List<ContactPhone>? = null, val social_medias: List<ContactSocialMedia>? = null, val addresses: List<ContactAddress>? = null, val emails: List<ContactEmail>? = null, val links: List<ContactLink>? = null, val birthday: String? = null, val id: String? = null)
@Serializable
data class ContactUpdateResponse(val contact: ContactContactInfo? = null)
