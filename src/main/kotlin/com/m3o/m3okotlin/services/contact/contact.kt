
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
    suspend fun create(req: ContactCreateRequest): ContactCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = req
        }
    }
    suspend fun delete(req: ContactDeleteRequest): ContactDeleteResponse {
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
internal data class ContactAddress(val label: String, val location: String)
@Serializable
internal data class ContactContactInfo(val birthday: String, val created_at: String, val emails: List<ContactEmail>, val id: String, val links: List<ContactLink>, val phones: List<ContactPhone>, val social_medias: List<ContactSocialMedia>, val addresses: List<ContactAddress>, val name: String, val note: String, val updated_at: String)
@Serializable
internal data class ContactCreateRequest(val name: String, val note: String, val phones: List<ContactPhone>, val social_medias: List<ContactSocialMedia>, val addresses: List<ContactAddress>, val birthday: String, val emails: List<ContactEmail>, val links: List<ContactLink>)
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
internal data class ContactUpdateRequest(val links: List<ContactLink>, val note: String, val phones: List<ContactPhone>, val social_medias: List<ContactSocialMedia>, val addresses: List<ContactAddress>, val emails: List<ContactEmail>, val name: String, val birthday: String, val id: String)
@Serializable
data class ContactUpdateResponse(val contact: ContactContactInfo)
