
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
      suspend fun delete(req: DbDeleteRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
      }
      suspend fun dropTable(req: DbDropTableRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "DropTable")) {
          body = req
        }
      }
      suspend fun listTables(): DbListTablesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "ListTables")) 
      }
      suspend fun read(req: DbReadRequest): DbReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
          body = req
        }
      }
      suspend fun renameTable(req: DbRenameTableRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "RenameTable")) {
          body = req
        }
      }
      suspend fun truncate(req: DbTruncateRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "Truncate")) {
          body = req
        }
      }
      suspend fun update(req: DbUpdateRequest){
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
data class DbCreateRequest(val id: String, Map<String, Any>, val table: String)
@Serializable
data class DbCreateResponse(val id: String)
@Serializable
data class DbDeleteRequest(val id: String, val table: String)
@Serializable
data class DbDropTableRequest(val table: String)
@Serializable
data class DbListTablesResponse(val tables: List<String>)
@Serializable
data class DbReadRequest(val order: String, val orderBy: String, val query: String, val table: String, val id: String, val limit: Int, val offset: Int)
@Serializable
data class DbReadResponse(val records: List<Map<String, Any>>)
@Serializable
data class DbRenameTableRequest(val from: String, val to: String)
@Serializable
data class DbTruncateRequest(val table: String)
@Serializable
data class DbUpdateRequest(val id: String, Map<String, Any>, val table: String)
