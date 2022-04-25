
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "search"

object SearchService {
    suspend fun createIndex(name: String): SearchCreateIndexResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "CreateIndex")) {
          body = SearchCreateIndexRequest(name)
        }
    }
    suspend fun deleteIndex(name: String): SearchDeleteIndexResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "DeleteIndex")) {
          body = SearchDeleteIndexRequest(name)
        }
    }
    suspend fun delete(name: String): SearchDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = SearchDeleteRequest(name)
        }
    }
    suspend fun index(name: String): SearchIndexResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Index")) {
          body = SearchIndexRequest(name)
        }
    }
    suspend fun search(name: String): SearchSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = SearchSearchRequest(name)
        }
    }
}
@Serializable
internal data class SearchCreateIndexRequest({/// The name of the index
String? index,})
@Serializable
data class SearchCreateIndexResponse()
@Serializable
internal data class SearchDeleteIndexRequest({/// The name of the index to delete
String? index,})
@Serializable
data class SearchDeleteIndexResponse()
@Serializable
internal data class SearchDeleteRequest({/// The ID of the record to delete
String? id, /// The index the record belongs to
String? index,})
@Serializable
data class SearchDeleteResponse()
@Serializable
internal data class SearchField({/// The name of the field. Use a `.` separator to define nested fields e.g. foo.bar
String? name, /// The type of the field - string, number
String? type,})
@Serializable
internal data class SearchIndexRequest({/// The data to index
Map<String, dynamic>? data, /// Optional ID for the record
String? id, /// The index this record belongs to
String? index,})
@Serializable
data class SearchIndexResponse({/// the indexed record
Record? record,})
@Serializable
internal data class SearchRecord({/// The JSON contents of the record
Map<String, dynamic>? data, /// The ID for this record. If blank, one will be generated
String? id,})
@Serializable
internal data class SearchSearchRequest({/// The index the record belongs to
String? index, /// The query. See docs for query language examples
String? query,})
@Serializable
data class SearchSearchResponse({/// The matching records
List<Record>? records,})
