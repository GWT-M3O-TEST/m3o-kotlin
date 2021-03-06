
package com.m3o.m3okotlin.services.file

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "file"

object FileServ {
      suspend fun delete(req: FileDeleteRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
      }
      suspend fun list(req: FileListRequest): FileListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = req
        }
      }
      suspend fun read(req: FileReadRequest): FileReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = req
        }
      }
      suspend fun save(req: FileSaveRequest): FileSaveResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Save")) {
          body = req
        }
      }
}
@Serializable
data class FileDeleteRequest(val path: String? = null, val project: String? = null)
@Serializable
data class FileListRequest(val path: String? = null, val project: String? = null)
@Serializable
data class FileListResponse(val files: List<FileRecord>? = null)
@Serializable
data class FileReadRequest(val path: String? = null, val project: String? = null)
@Serializable
data class FileReadResponse(val file: FileRecord? = null)
@Serializable
data class FileRecord(val updated: String? = null, val content: String? = null, val created: String? = null, val metadata: Map<String, String>? = null, val path: String? = null, val project: String? = null)
@Serializable
data class FileSaveRequest(val public: Boolean? = null, val file: FileRecord? = null)
@Serializable
data class FileSaveResponse(val url: String? = null)
