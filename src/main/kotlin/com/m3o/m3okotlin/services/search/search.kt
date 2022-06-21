
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
}
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
    suspend fun deleteIndex(req: SearchDeleteIndexRequest){
      return ktorHttpClient.post(getUrl(SERVICE, "DeleteIndex")) {
        body = req
      }
    }
}
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
    suspend fun delete(req: SearchDeleteRequest){
      return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
        body = req
      }
    }
}
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
    suspend fun index(req: SearchIndexRequest): SearchIndexResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Index")) {
          body = req
        }
    }
}
    suspend fun search(req: SearchSearchRequest): SearchSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = req
        }
    }
}
