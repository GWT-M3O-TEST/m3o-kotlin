
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
    suspend fun delete(req: AppDeleteRequest): AppDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
    }
    suspend fun list(req: AppListRequest): AppListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = req
        }
    }
    suspend fun logs(req: AppLogsRequest): AppLogsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Logs")) {
          body = req
        }
    }
    suspend fun regions(req: AppRegionsRequest): AppRegionsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Regions")) {
          body = req
        }
    }
    suspend fun reserve(req: AppReserveRequest): AppReserveResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Reserve")) {
          body = req
        }
    }
    suspend fun resolve(req: AppResolveRequest): AppResolveResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Resolve")) {
          body = req
        }
    }
    suspend fun run(req: AppRunRequest): AppRunResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Run")) {
          body = req
        }
    }
    suspend fun status(req: AppStatusRequest): AppStatusResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Status")) {
          body = req
        }
    }
    suspend fun update(req: AppUpdateRequest): AppUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = req
        }
    }
}
@Serializable
data class AppDeleteRequest(val name: String)
@Serializable
data class AppDeleteResponse()
@Serializable
data class AppListRequest()
@Serializable
data class AppListResponse(val services: List<AppService>)
@Serializable
data class AppLogsRequest(val logs_type: String, val name: String)
@Serializable
data class AppLogsResponse(val logs: String)
@Serializable
data class AppRegionsRequest()
@Serializable
data class AppRegionsResponse(val regions: List<AppString>)
@Serializable
data class AppReservation(val name: String, val owner: String, val token: String, val created: String, val expires: String)
@Serializable
data class AppReserveRequest(val name: String)
@Serializable
data class AppReserveResponse(val reservation: AppReservation)
@Serializable
data class AppResolveRequest(val id: String)
@Serializable
data class AppResolveResponse(val url: String)
@Serializable
data class AppRunRequest(val repo: String, val branch: String, val env_vars: Map<String, String>, val name: String, val port: Int, val region: String)
@Serializable
data class AppRunResponse(val service: AppService)
@Serializable
data class AppService(val env_vars: Map<String, String>, val id: String, val name: String, val region: String, val status: String, val created: String, val custom_domains: List<AppString>, val port: Int, val repo: String, val updated: String, val url: String, val branch: String)
@Serializable
data class AppStatusRequest(val name: String)
@Serializable
data class AppStatusResponse(val service: AppService)
@Serializable
data class AppUpdateRequest(val env_vars: Map<String, String>, val name: String)
@Serializable
data class AppUpdateResponse()
