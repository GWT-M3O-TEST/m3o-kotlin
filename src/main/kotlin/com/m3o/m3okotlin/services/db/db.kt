
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "db"

object DbService {
    suspend fun count(name: String): DbCountResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Count")) {
          body = DbCountRequest(name)
        }
    }
    suspend fun create(name: String): DbCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = DbCreateRequest(name)
        }
    }
    suspend fun delete(name: String): DbDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = DbDeleteRequest(name)
        }
    }
    suspend fun dropTable(name: String): DbDropTableResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "DropTable")) {
          body = DbDropTableRequest(name)
        }
    }
    suspend fun listTables(name: String): DbListTablesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "ListTables")) {
          body = DbListTablesRequest(name)
        }
    }
    suspend fun read(name: String): DbReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = DbReadRequest(name)
        }
    }
    suspend fun renameTable(name: String): DbRenameTableResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "RenameTable")) {
          body = DbRenameTableRequest(name)
        }
    }
    suspend fun truncate(name: String): DbTruncateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Truncate")) {
          body = DbTruncateRequest(name)
        }
    }
    suspend fun update(name: String): DbUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = DbUpdateRequest(name)
        }
    }
}
@Serializable
internal data class DbCountRequest()
@Serializable
data class DbCountResponse()
@Serializable
internal data class DbCreateRequest()
@Serializable
data class DbCreateResponse()
@Serializable
internal data class DbDeleteRequest()
@Serializable
data class DbDeleteResponse()
@Serializable
internal data class DbDropTableRequest()
@Serializable
data class DbDropTableResponse()
@Serializable
internal data class DbListTablesRequest()
@Serializable
data class DbListTablesResponse()
@Serializable
internal data class DbReadRequest()
@Serializable
data class DbReadResponse()
@Serializable
internal data class DbRenameTableRequest()
@Serializable
data class DbRenameTableResponse()
@Serializable
internal data class DbTruncateRequest()
@Serializable
data class DbTruncateResponse()
@Serializable
internal data class DbUpdateRequest()
@Serializable
data class DbUpdateResponse()
