
package com.m3o.m3okotlin.services.db

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "db"

object DbService {
    suspend fun count(req: DbCountRequest): DbCountResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Count")) {
          body = req
        }
    }
    suspend fun create(req: DbCreateRequest): DbCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = req
        }
    }
    suspend fun delete(req: DbDeleteRequest): DbDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
    }
    suspend fun dropTable(req: DbDropTableRequest): DbDropTableResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "DropTable")) {
          body = req
        }
    }
    suspend fun listTables(req: DbListTablesRequest): DbListTablesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "ListTables")) {
          body = req
        }
    }
    suspend fun read(req: DbReadRequest): DbReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = req
        }
    }
    suspend fun renameTable(req: DbRenameTableRequest): DbRenameTableResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "RenameTable")) {
          body = req
        }
    }
    suspend fun truncate(req: DbTruncateRequest): DbTruncateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Truncate")) {
          body = req
        }
    }
    suspend fun update(req: DbUpdateRequest): DbUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = req
        }
    }
}
@Serializable
data class DbCountRequest(val table: String)
@Serializable
data class DbCountResponse(val count: Int)
@Serializable
data class DbCreateRequest(val id: String, val record: DbMap<String, dynamic>, val table: String)
@Serializable
data class DbCreateResponse(val id: String)
@Serializable
data class DbDeleteRequest(val id: String, val table: String)
@Serializable
data class DbDeleteResponse()
@Serializable
data class DbDropTableRequest(val table: String)
@Serializable
data class DbDropTableResponse()
@Serializable
data class DbListTablesRequest()
@Serializable
data class DbListTablesResponse(val tables: List<DbString>)
@Serializable
data class DbReadRequest(val offset: Int, val order: String, val orderBy: String, val query: String, val table: String, val id: String, val limit: Int)
@Serializable
data class DbReadResponse(val records: List<DbMap<String, dynamic>>)
@Serializable
data class DbRenameTableRequest(val from: String, val to: String)
@Serializable
data class DbRenameTableResponse()
@Serializable
data class DbTruncateRequest(val table: String)
@Serializable
data class DbTruncateResponse()
@Serializable
data class DbUpdateRequest(val id: String, val record: DbMap<String, dynamic>, val table: String)
@Serializable
data class DbUpdateResponse()
