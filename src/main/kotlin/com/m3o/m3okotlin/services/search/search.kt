
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
internal data class SearchCreateIndexRequest(val index: String)
@Serializable
data class SearchCreateIndexResponse()
@Serializable
internal data class SearchDeleteIndexRequest(val index: String)
@Serializable
data class SearchDeleteIndexResponse()
@Serializable
internal data class SearchDeleteRequest(val id: String, val index: String)
@Serializable
data class SearchDeleteResponse()
@Serializable
internal data class SearchField(val name: String, val type: String)
@Serializable
internal data class SearchIndexRequest(val data: SearchMap<String, dynamic>, val id: String, val index: String)
@Serializable
data class SearchIndexResponse(val record: SearchRecord)
@Serializable
internal data class SearchRecord(val data: SearchMap<String, dynamic>, val id: String)
@Serializable
internal data class SearchSearchRequest(val index: String, val query: String)
@Serializable
data class SearchSearchResponse(val records: List<SearchRecord>)
