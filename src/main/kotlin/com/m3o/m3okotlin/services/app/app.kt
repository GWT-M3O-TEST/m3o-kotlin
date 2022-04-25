
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
internal data class AppDeleteRequest({/// name of the app
String? name,})
@Serializable
data class AppDeleteResponse()
@Serializable
internal data class AppListRequest()
@Serializable
data class AppListResponse({/// all the apps
List<Service>? services,})
@Serializable
internal data class AppLogsRequest({/// type of logs to retrieve, currently supported options - "build"
String? logs_type, /// name of the app
String? name,})
@Serializable
data class AppLogsResponse({String? logs,})
@Serializable
internal data class AppRegionsRequest()
@Serializable
data class AppRegionsResponse({List<String>? regions,})
@Serializable
internal data class AppReservation({/// time reservation expires
String? expires, /// name of the app
String? name, /// owner id
String? owner, /// associated token
String? token, /// time of reservation
String? created,})
@Serializable
internal data class AppReserveRequest({/// name of your app e.g helloworld
String? name,})
@Serializable
data class AppReserveResponse({/// The app reservation
Reservation? reservation,})
@Serializable
internal data class AppResolveRequest({/// the service id
String? id,})
@Serializable
data class AppResolveResponse({/// the end provider url
String? url,})
@Serializable
internal data class AppRunRequest({/// name of the app
String? name, /// port to run on
int? port, /// region to run in
String? region, /// source repository
String? repo, /// branch. defaults to master
String? branch, /// associated env vars to pass in
Map<String, String>? env_vars,})
@Serializable
data class AppRunResponse({/// The running service
Service? service,})
@Serializable
internal data class AppService({/// time of creation
String? created, /// name of the app
String? name, /// region running in
String? region, /// source repository
String? repo, /// status of the app
String? status, /// last updated
String? updated, /// branch of code
String? branch, /// custom domains
List<String>? custom_domains, /// associated env vars
Map<String, String>? env_vars, /// unique id
String? id, /// port running on
int? port, /// app url
String? url,})
@Serializable
internal data class AppStatusRequest({/// name of the app
String? name,})
@Serializable
data class AppStatusResponse({/// running service info
Service? service,})
@Serializable
internal data class AppUpdateRequest({/// Additional env vars to update
Map<String, String>? env_vars, /// name of the app
String? name,})
@Serializable
data class AppUpdateResponse()
