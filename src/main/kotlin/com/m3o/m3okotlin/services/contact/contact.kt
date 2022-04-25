
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
internal data class ContactAddress({/// the label of the address
String? label, /// the address location
String? location,})
@Serializable
internal data class ContactContactInfo({/// the address
List<Address>? addresses, /// the birthday
String? birthday, /// create date string in RFC3339
String? created_at, /// contact id
String? id, /// the contact links
List<Link>? links, /// note of the contact
String? note, /// the social media username
List<SocialMedia>? social_medias, /// the emails
List<Email>? emails, /// the contact name
String? name, /// the phone numbers
List<Phone>? phones, /// update date string in RFC3339
String? updated_at,})
@Serializable
internal data class ContactCreateRequest({/// optional, note of the contact
String? note, /// optional, phone numbers
List<Phone>? phones, /// optional, social media
List<SocialMedia>? social_medias, /// optional, location
List<Address>? addresses, /// optional, birthday
String? birthday, /// optional, emails
List<Email>? emails, /// optional, links
List<Link>? links, /// required, the name of the contact
String? name,})
@Serializable
data class ContactCreateResponse({ContactInfo? contact,})
@Serializable
internal data class ContactDeleteRequest({/// the id of the contact
String? id,})
@Serializable
data class ContactDeleteResponse()
@Serializable
internal data class ContactEmail({/// the email address
String? address, /// the label of the email
String? label,})
@Serializable
internal data class ContactLink({/// the label of the link
String? label, /// the url of the contact
String? url,})
@Serializable
internal data class ContactListRequest({/// optional, default is 30
int? limit, /// optional
int? offset,})
@Serializable
data class ContactListResponse({List<ContactInfo>? contacts,})
@Serializable
internal data class ContactPhone({/// the label of the phone number
String? label, /// phone number
String? number,})
@Serializable
internal data class ContactReadRequest({String? id,})
@Serializable
data class ContactReadResponse({ContactInfo? contact,})
@Serializable
internal data class ContactSocialMedia({/// the label of the social
String? label, /// the username of social media
String? username,})
@Serializable
internal data class ContactUpdateRequest({/// optional, addresses
List<Address>? addresses, /// optional, birthday
String? birthday, /// optional, emails
List<Email>? emails, /// required, the contact id
String? id, /// required, the name
String? name, /// optional, links
List<Link>? links, /// optional, note
String? note, /// optional, phone number
List<Phone>? phones, /// optional, social media
List<SocialMedia>? social_medias,})
@Serializable
data class ContactUpdateResponse({ContactInfo? contact,})
