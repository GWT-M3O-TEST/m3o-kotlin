
package com.m3o.m3okotlin.services.app

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "app"

object AppServ {
      suspend fun delete(req: AppDeleteRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
      }
      suspend fun list(): AppListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) 
      }
      suspend fun logs(req: AppLogsRequest): AppLogsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Logs")) {
          body = req
        }
      }
      suspend fun regions(): AppRegionsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Regions")) 
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
      suspend fun update(req: AppUpdateRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = req
        }
      }
}
@Serializable
data class AppDeleteRequest(val name: String? = null)
@Serializable
data class AppListResponse(val services: List<AppService>? = null)
@Serializable
data class AppLogsRequest(val logs_type: String? = null, val name: String? = null)
@Serializable
data class AppLogsResponse(val logs: String? = null)
@Serializable
data class AppRegionsResponse(val regions: List<String>? = null)
@Serializable
data class AppReservation(val owner: String? = null, val token: String? = null, val created: String? = null, val expires: String? = null, val name: String? = null)
@Serializable
data class AppReserveRequest(val name: String? = null)
@Serializable
data class AppReserveResponse(val reservation: AppReservation? = null)
@Serializable
data class AppResolveRequest(val id: String? = null)
@Serializable
data class AppResolveResponse(val url: String? = null)
@Serializable
data class AppRunRequest(val port: Int? = null, val region: String? = null, val repo: String? = null, val branch: String? = null, val env_vars: Map<String, String>? = null, val name: String? = null)
@Serializable
data class AppRunResponse(val service: AppService? = null)
@Serializable
data class AppService(val updated: String? = null, val url: String? = null, val created: String? = null, val region: String? = null, val status: String? = null, val id: String? = null, val name: String? = null, val port: Int? = null, val repo: String? = null, val branch: String? = null, val custom_domains: List<String>? = null, val env_vars: Map<String, String>? = null)
@Serializable
data class AppStatusRequest(val name: String? = null)
@Serializable
data class AppStatusResponse(val service: AppService? = null)
@Serializable
data class AppUpdateRequest(val env_vars: Map<String, String>? = null, val name: String? = null)
