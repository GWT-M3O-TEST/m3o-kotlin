
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
internal data class ContactAddress()
@Serializable
internal data class ContactContactInfo()
@Serializable
internal data class ContactCreateRequest()
@Serializable
data class ContactCreateResponse()
@Serializable
internal data class ContactDeleteRequest()
@Serializable
data class ContactDeleteResponse()
@Serializable
internal data class ContactEmail()
@Serializable
internal data class ContactLink()
@Serializable
internal data class ContactListRequest()
@Serializable
data class ContactListResponse()
@Serializable
internal data class ContactPhone()
@Serializable
internal data class ContactReadRequest()
@Serializable
data class ContactReadResponse()
@Serializable
internal data class ContactSocialMedia()
@Serializable
internal data class ContactUpdateRequest()
@Serializable
data class ContactUpdateResponse()
