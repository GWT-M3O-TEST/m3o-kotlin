
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "contact"

object ContactService {
    suspend fun create(name: String): ContactCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = ContactCreateRequest(name)
        }
    }
    suspend fun delete(name: String): ContactDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = ContactDeleteRequest(name)
        }
    }
    suspend fun list(name: String): ContactListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = ContactListRequest(name)
        }
    }
    suspend fun read(name: String): ContactReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = ContactReadRequest(name)
        }
    }
    suspend fun update(name: String): ContactUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = ContactUpdateRequest(name)
        }
    }
}
@Serializable
internal data class ContactAddress(val label: String, val location: String)
@Serializable
internal data class ContactContactInfo(val emails: List<ContactEmail>, val links: List<ContactLink>, val note: String, val phones: List<ContactPhone>, val social_medias: List<ContactSocialMedia>, val addresses: List<ContactAddress>, val birthday: String, val created_at: String, val id: String, val name: String, val updated_at: String)
@Serializable
internal data class ContactCreateRequest(val addresses: List<ContactAddress>, val birthday: String, val emails: List<ContactEmail>, val links: List<ContactLink>, val name: String, val note: String, val phones: List<ContactPhone>, val social_medias: List<ContactSocialMedia>)
@Serializable
data class ContactCreateResponse(val contact: ContactContactInfo)
@Serializable
internal data class ContactDeleteRequest(val id: String)
@Serializable
data class ContactDeleteResponse()
@Serializable
internal data class ContactEmail(val address: String, val label: String)
@Serializable
internal data class ContactLink(val label: String, val url: String)
@Serializable
internal data class ContactListRequest(val limit: Int, val offset: Int)
@Serializable
data class ContactListResponse(val contacts: List<ContactContactInfo>)
@Serializable
internal data class ContactPhone(val label: String, val number: String)
@Serializable
internal data class ContactReadRequest(val id: String)
@Serializable
data class ContactReadResponse(val contact: ContactContactInfo)
@Serializable
internal data class ContactSocialMedia(val label: String, val username: String)
@Serializable
internal data class ContactUpdateRequest(val name: String, val social_medias: List<ContactSocialMedia>, val birthday: String, val emails: List<ContactEmail>, val id: String, val links: List<ContactLink>, val note: String, val phones: List<ContactPhone>, val addresses: List<ContactAddress>)
@Serializable
data class ContactUpdateResponse(val contact: ContactContactInfo)
