
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
internal data class AppDeleteRequest(val name: String)
@Serializable
data class AppDeleteResponse()
@Serializable
internal data class AppListRequest()
@Serializable
data class AppListResponse(val services: List<AppService>)
@Serializable
internal data class AppLogsRequest(val logs_type: String, val name: String)
@Serializable
data class AppLogsResponse(val logs: String)
@Serializable
internal data class AppRegionsRequest()
@Serializable
data class AppRegionsResponse(val regions: List<AppString>)
@Serializable
internal data class AppReservation(val owner: String, val token: String, val created: String, val expires: String, val name: String)
@Serializable
internal data class AppReserveRequest(val name: String)
@Serializable
data class AppReserveResponse(val reservation: AppReservation)
@Serializable
internal data class AppResolveRequest(val id: String)
@Serializable
data class AppResolveResponse(val url: String)
@Serializable
internal data class AppRunRequest(val region: String, val repo: String, val branch: String, val env_vars: Map<String, String>, val name: String, val port: Int)
@Serializable
data class AppRunResponse(val service: AppService)
@Serializable
internal data class AppService(val created: String, val id: String, val port: Int, val region: String, val updated: String, val url: String, val branch: String, val custom_domains: List<AppString>, val env_vars: Map<String, String>, val name: String, val repo: String, val status: String)
@Serializable
internal data class AppStatusRequest(val name: String)
@Serializable
data class AppStatusResponse(val service: AppService)
@Serializable
internal data class AppUpdateRequest(val env_vars: Map<String, String>, val name: String)
@Serializable
data class AppUpdateResponse()
