
package com.m3o.m3okotlin.services.db

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "db"

object DbServ {
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
data class DbCountRequest(val table: String? = null)
@Serializable
data class DbCountResponse(val count: Int? = null)
@Serializable
data class DbCreateRequest(val id: String? = null, val record: JsonObject? = null, val table: String? = null)
@Serializable
data class DbCreateResponse(val id: String? = null)
@Serializable
data class DbDeleteRequest(val table: String? = null, val id: String? = null)
@Serializable
data class DbDropTableRequest(val table: String? = null)
@Serializable
data class DbListTablesResponse(val tables: List<String>? = null)
@Serializable
data class DbReadRequest(val offset: Int? = null, val order: String? = null, val orderBy: String? = null, val query: String? = null, val table: String? = null, val id: String? = null, val limit: Int? = null)
@Serializable
data class DbReadResponse(val records: List<JsonObject>? = null)
@Serializable
data class DbRenameTableRequest(val from: String? = null, val to: String? = null)
@Serializable
data class DbTruncateRequest(val table: String? = null)
@Serializable
data class DbUpdateRequest(val id: String? = null, val record: JsonObject? = null, val table: String? = null)
