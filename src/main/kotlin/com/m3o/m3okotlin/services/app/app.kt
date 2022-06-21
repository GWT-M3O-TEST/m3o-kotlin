
package com.m3o.m3okotlin.services.app

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "app"

object AppService {
    suspend fun delete(req: AppDeleteRequest){
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
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
    suspend fun list(): AppListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) 
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
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
    suspend fun logs(req: AppLogsRequest): AppLogsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Logs")) {
          body = req
        }
    }
}
    suspend fun regions(): AppRegionsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Regions")) 
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
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
    suspend fun reserve(req: AppReserveRequest): AppReserveResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Reserve")) {
          body = req
        }
    }
}
    suspend fun resolve(req: AppResolveRequest): AppResolveResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Resolve")) {
          body = req
        }
    }
}
    suspend fun run(req: AppRunRequest): AppRunResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Run")) {
          body = req
        }
    }
}
    suspend fun status(req: AppStatusRequest): AppStatusResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Status")) {
          body = req
        }
    }
}
    suspend fun update(req: AppUpdateRequest){
      return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
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
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
