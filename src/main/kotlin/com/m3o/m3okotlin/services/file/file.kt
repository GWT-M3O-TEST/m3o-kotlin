
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "file"

object FileService {
    suspend fun delete(name: String): FileDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = FileDeleteRequest(name)
        }
    }
    suspend fun list(name: String): FileListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = FileListRequest(name)
        }
    }
    suspend fun read(name: String): FileReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = FileReadRequest(name)
        }
    }
    suspend fun save(name: String): FileSaveResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Save")) {
          body = FileSaveRequest(name)
        }
    }
}
@Serializable
internal data class FileDeleteRequest({/// Path to the file
String? path, /// The project name
String? project,})
@Serializable
data class FileDeleteResponse()
@Serializable
internal data class FileListRequest({/// Defaults to '/', ie. lists all files in a project.
/// Supply path to a folder if you want to list
/// files inside that folder
/// eg. '/docs'
String? path, /// Project, required for listing.
String? project,})
@Serializable
data class FileListResponse({List<Record>? files,})
@Serializable
internal data class FileReadRequest({/// Path to the file
String? path, /// Project name
String? project,})
@Serializable
data class FileReadResponse({/// Returns the file
Record? file,})
@Serializable
internal data class FileRecord({/// File contents
String? content, /// Time the file was created e.g 2021-05-20T13:37:21Z
String? created, /// Any other associated metadata as a map of key-value pairs
Map<String, String>? metadata, /// Path to file or folder eg. '/documents/text-files/file.txt'.
String? path, /// A custom project to group files
/// eg. file-of-mywebsite.com
String? project, /// Time the file was updated e.g 2021-05-20T13:37:21Z
String? updated,})
@Serializable
internal data class FileSaveRequest({/// Make the file public: true or false
bool? public, /// The file to save
Record? file,})
@Serializable
data class FileSaveResponse({/// The permalink for the file if made public
String? url,})
