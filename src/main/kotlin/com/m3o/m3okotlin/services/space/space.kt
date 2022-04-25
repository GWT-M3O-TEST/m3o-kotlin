
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "space"

object SpaceService {
    suspend fun create(name: String): SpaceCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = SpaceCreateRequest(name)
        }
    }
    suspend fun delete(name: String): SpaceDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = SpaceDeleteRequest(name)
        }
    }
    suspend fun download(name: String): SpaceDownloadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Download")) {
          body = SpaceDownloadRequest(name)
        }
    }
    suspend fun head(name: String): SpaceHeadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Head")) {
          body = SpaceHeadRequest(name)
        }
    }
    suspend fun list(name: String): SpaceListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = SpaceListRequest(name)
        }
    }
    suspend fun read(name: String): SpaceReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = SpaceReadRequest(name)
        }
    }
    suspend fun update(name: String): SpaceUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = SpaceUpdateRequest(name)
        }
    }
    suspend fun upload(name: String): SpaceUploadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Upload")) {
          body = SpaceUploadRequest(name)
        }
    }
}
@Serializable
internal data class SpaceCreateRequest({/// Who can see this object? "public" or "private", defaults to "private"
String? visibility, /// The name of the object. Use forward slash delimiter to implement a nested directory-like structure e.g. images/foo.jpg
String? name, /// The contents of the object. Either base64 encoded if sending request as application/json or raw bytes if using multipart/form-data format
String? object,})
@Serializable
data class SpaceCreateResponse({/// A public URL to access the object if visibility is "public"
String? url,})
@Serializable
internal data class SpaceDeleteRequest({/// Name of the object
String? name,})
@Serializable
data class SpaceDeleteResponse()
@Serializable
internal data class SpaceDownloadRequest({/// name of object
String? name,})
@Serializable
data class SpaceDownloadResponse({/// presigned url
String? url,})
@Serializable
internal data class SpaceHeadObject({/// when was this created
String? created, /// when was this last modified
String? modified, String? name, /// URL to access the object if it is public
String? url, /// is this public or private
String? visibility,})
@Serializable
internal data class SpaceHeadRequest({/// name of the object
String? name,})
@Serializable
data class SpaceHeadResponse({HeadObject? object,})
@Serializable
internal data class SpaceListObject({String? created, /// when was this last modified
String? modified, String? name, String? url, String? visibility,})
@Serializable
internal data class SpaceListRequest({/// optional prefix for the name e.g. to return all the objects in the images directory pass images/
String? prefix,})
@Serializable
data class SpaceListResponse({List<ListObject>? objects,})
@Serializable
internal data class SpaceReadRequest({/// name of the object
String? name,})
@Serializable
data class SpaceReadResponse({/// The object itself
SpaceObject? object,})
@Serializable
internal data class SpaceSpaceObject({/// when was this created
String? created, /// the data within the object
String? data, /// when was this last modified
String? modified, /// name of object
String? name, /// URL to access the object if it is public
String? url, /// is this public or private
String? visibility,})
@Serializable
internal data class SpaceUpdateRequest({/// Who can see this object? "public" or "private", defaults to "private"
String? visibility, /// The name of the object. Use forward slash delimiter to implement a nested directory-like structure e.g. images/foo.jpg
String? name, /// The contents of the object. Either base64 encoded if sending request as application/json or raw bytes if using multipart/form-data format
String? object,})
@Serializable
data class SpaceUpdateResponse({/// A public URL to access the object if visibility is "public"
String? url,})
@Serializable
internal data class SpaceUploadRequest({String? name, /// is this object public or private
String? visibility,})
@Serializable
data class SpaceUploadResponse({/// a presigned url to be used for uploading. To use the URL call it with HTTP PUT and pass the object as the request data
String? url,})
