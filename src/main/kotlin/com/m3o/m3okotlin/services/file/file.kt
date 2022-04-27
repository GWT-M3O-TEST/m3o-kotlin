
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
internal data class FileDeleteRequest()
@Serializable
data class FileDeleteResponse()
@Serializable
internal data class FileListRequest()
@Serializable
data class FileListResponse()
@Serializable
internal data class FileReadRequest()
@Serializable
data class FileReadResponse()
@Serializable
internal data class FileRecord()
@Serializable
internal data class FileSaveRequest()
@Serializable
data class FileSaveResponse()
