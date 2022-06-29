
package com.m3o.m3okotlin.services.file

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "file"

object FileService {
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
data class FileDeleteRequest(val path: String, val project: String)
@Serializable
data class FileListRequest(val path: String, val project: String)
@Serializable
data class FileListResponse(val files: List<FileRecord>)
@Serializable
data class FileReadRequest(val path: String, val project: String)
@Serializable
data class FileReadResponse(val file: FileRecord)
@Serializable
data class FileRecord(val updated: String, val content: String, val created: String, val metadata: Map<String, String>, val path: String, val project: String)
@Serializable
data class FileSaveRequest(val file: FileRecord, val public: Boolean)
@Serializable
data class FileSaveResponse(val url: String)
