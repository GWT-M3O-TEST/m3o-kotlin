
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

object ContactService {
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
data class ContactAddress(val label: String, val location: String)
@Serializable
data class ContactContactInfo(val created_at: String, val emails: List<ContactEmail>, val phones: List<ContactPhone>, val social_medias: List<ContactSocialMedia>, val updated_at: String, val addresses: List<ContactAddress>, val id: String, val links: List<ContactLink>, val name: String, val note: String, val birthday: String)
@Serializable
data class ContactCreateRequest(val phones: List<ContactPhone>, val social_medias: List<ContactSocialMedia>, val addresses: List<ContactAddress>, val birthday: String, val emails: List<ContactEmail>, val links: List<ContactLink>, val name: String, val note: String)
@Serializable
data class ContactCreateResponse(val contact: ContactContactInfo)
@Serializable
data class ContactDeleteRequest(val id: String)
@Serializable
data class ContactEmail(val address: String, val label: String)
@Serializable
data class ContactLink(val label: String, val url: String)
@Serializable
data class ContactListRequest(val limit: Int, val offset: Int)
@Serializable
data class ContactListResponse(val contacts: List<ContactContactInfo>)
@Serializable
data class ContactPhone(val label: String, val number: String)
@Serializable
data class ContactReadRequest(val id: String)
@Serializable
data class ContactReadResponse(val contact: ContactContactInfo)
@Serializable
data class ContactSocialMedia(val label: String, val username: String)
@Serializable
data class ContactUpdateRequest(val addresses: List<ContactAddress>, val note: String, val phones: List<ContactPhone>, val social_medias: List<ContactSocialMedia>, val birthday: String, val emails: List<ContactEmail>, val id: String, val links: List<ContactLink>, val name: String)
@Serializable
data class ContactUpdateResponse(val contact: ContactContactInfo)
