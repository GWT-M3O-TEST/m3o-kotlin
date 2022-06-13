
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
    suspend fun createIndex(req: SearchCreateIndexRequest): SearchCreateIndexResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "CreateIndex")) {
          body = req
        }
    }
    suspend fun deleteIndex(req: SearchDeleteIndexRequest): SearchDeleteIndexResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "DeleteIndex")) {
          body = req
        }
    }
    suspend fun delete(req: SearchDeleteRequest): SearchDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
    }
    suspend fun index(req: SearchIndexRequest): SearchIndexResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Index")) {
          body = req
        }
    }
    suspend fun search(req: SearchSearchRequest): SearchSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = req
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
internal data class SearchDeleteRequest(val index: String, val id: String)
@Serializable
data class SearchDeleteResponse()
@Serializable
internal data class SearchField(val type: String, val name: String)
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
