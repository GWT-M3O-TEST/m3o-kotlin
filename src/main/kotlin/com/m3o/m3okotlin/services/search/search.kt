
package com.m3o.m3okotlin.services.search

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "search"

object SearchService {
      suspend fun createIndex(req: SearchCreateIndexRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "CreateIndex")) {
          body = req
        }
      }
      suspend fun deleteIndex(req: SearchDeleteIndexRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "DeleteIndex")) {
          body = req
        }
      }
      suspend fun delete(req: SearchDeleteRequest){
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
data class SearchCreateIndexRequest(val index: String)
@Serializable
data class SearchDeleteIndexRequest(val index: String)
@Serializable
data class SearchDeleteRequest(val id: String, val index: String)
@Serializable
data class SearchField(val name: String, val type: String)
@Serializable
data class SearchIndexRequest(val index: String, JsonObject, val id: String)
@Serializable
data class SearchIndexResponse(val record: SearchRecord)
@Serializable
data class SearchRecord(JsonObject, val id: String)
@Serializable
data class SearchSearchRequest(val query: String, val index: String)
@Serializable
data class SearchSearchResponse(val records: List<SearchRecord>)
