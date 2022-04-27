
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
internal data class DbCountRequest(val table: String)
@Serializable
data class DbCountResponse(val count: Int)
@Serializable
internal data class DbCreateRequest(val id: String, val record: DbMap<String, dynamic>, val table: String)
@Serializable
data class DbCreateResponse(val id: String)
@Serializable
internal data class DbDeleteRequest(val id: String, val table: String)
@Serializable
data class DbDeleteResponse()
@Serializable
internal data class DbDropTableRequest(val table: String)
@Serializable
data class DbDropTableResponse()
@Serializable
internal data class DbListTablesRequest()
@Serializable
data class DbListTablesResponse(val tables: List<DbString>)
@Serializable
internal data class DbReadRequest(val order: String, val orderBy: String, val query: String, val table: String, val id: String, val limit: Int, val offset: Int)
@Serializable
data class DbReadResponse(val records: List<DbMap<String, dynamic>>)
@Serializable
internal data class DbRenameTableRequest(val from: String, val to: String)
@Serializable
data class DbRenameTableResponse()
@Serializable
internal data class DbTruncateRequest(val table: String)
@Serializable
data class DbTruncateResponse()
@Serializable
internal data class DbUpdateRequest(val id: String, val record: DbMap<String, dynamic>, val table: String)
@Serializable
data class DbUpdateResponse()
