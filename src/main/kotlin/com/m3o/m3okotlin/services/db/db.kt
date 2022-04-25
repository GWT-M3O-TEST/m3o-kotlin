
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
internal data class DbCountRequest({/// specify the table name
String? table,})
@Serializable
data class DbCountResponse({/// the number of records in the table
int? count,})
@Serializable
internal data class DbCreateRequest({/// optional record id to use
String? id, /// JSON encoded record or records (can be array or object)
Map<String, dynamic>? record, /// Optional table name. Defaults to 'default'
String? table,})
@Serializable
data class DbCreateResponse({/// The id of the record (either specified or automatically created)
String? id,})
@Serializable
internal data class DbDeleteRequest({/// id of the record
String? id, /// Optional table name. Defaults to 'default'
String? table,})
@Serializable
data class DbDeleteResponse()
@Serializable
internal data class DbDropTableRequest({String? table,})
@Serializable
data class DbDropTableResponse()
@Serializable
internal data class DbListTablesRequest()
@Serializable
data class DbListTablesResponse({/// list of tables
List<String>? tables,})
@Serializable
internal data class DbReadRequest({int? offset, /// 'asc' (default), 'desc'
String? order, /// field name to order by
String? orderBy, /// Examples: 'age >= 18', 'age >= 18 and verified == true'
/// Comparison operators: '==', '!=', '<', '>', '<=', '>='
/// Logical operator: 'and'
/// Dot access is supported, eg: 'user.age == 11'
/// Accessing list elements is not supported yet.
String? query, /// Optional table name. Defaults to 'default'
String? table, /// Read by id. Equivalent to 'id == "your-id"'
String? id, /// Maximum number of records to return. Default limit is 25.
/// Maximum limit is 1000. Anything higher will return an error.
int? limit,})
@Serializable
data class DbReadResponse({/// JSON encoded records
List<Map<String, dynamic>>? records,})
@Serializable
internal data class DbRenameTableRequest({/// current table name
String? from, /// new table name
String? to,})
@Serializable
data class DbRenameTableResponse()
@Serializable
internal data class DbTruncateRequest({String? table,})
@Serializable
data class DbTruncateResponse()
@Serializable
internal data class DbUpdateRequest({/// Optional table name. Defaults to 'default'
String? table, /// The id of the record. If not specified it is inferred from the 'id' field of the record
String? id, /// record, JSON object
Map<String, dynamic>? record,})
@Serializable
data class DbUpdateResponse()
