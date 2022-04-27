
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "app"

object AppService {
    suspend fun delete(name: String): AppDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = AppDeleteRequest(name)
        }
    }
    suspend fun list(name: String): AppListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = AppListRequest(name)
        }
    }
    suspend fun logs(name: String): AppLogsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Logs")) {
          body = AppLogsRequest(name)
        }
    }
    suspend fun regions(name: String): AppRegionsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Regions")) {
          body = AppRegionsRequest(name)
        }
    }
    suspend fun reserve(name: String): AppReserveResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Reserve")) {
          body = AppReserveRequest(name)
        }
    }
    suspend fun resolve(name: String): AppResolveResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Resolve")) {
          body = AppResolveRequest(name)
        }
    }
    suspend fun run(name: String): AppRunResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Run")) {
          body = AppRunRequest(name)
        }
    }
    suspend fun status(name: String): AppStatusResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Status")) {
          body = AppStatusRequest(name)
        }
    }
    suspend fun update(name: String): AppUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = AppUpdateRequest(name)
        }
    }
}
@Serializable
internal data class AppDeleteRequest()
@Serializable
data class AppDeleteResponse()
@Serializable
internal data class AppListRequest()
@Serializable
data class AppListResponse()
@Serializable
internal data class AppLogsRequest()
@Serializable
data class AppLogsResponse()
@Serializable
internal data class AppRegionsRequest()
@Serializable
data class AppRegionsResponse()
@Serializable
internal data class AppReservation()
@Serializable
internal data class AppReserveRequest()
@Serializable
data class AppReserveResponse()
@Serializable
internal data class AppResolveRequest()
@Serializable
data class AppResolveResponse()
@Serializable
internal data class AppRunRequest()
@Serializable
data class AppRunResponse()
@Serializable
internal data class AppService()
@Serializable
internal data class AppStatusRequest()
@Serializable
data class AppStatusResponse()
@Serializable
internal data class AppUpdateRequest()
@Serializable
data class AppUpdateResponse()
