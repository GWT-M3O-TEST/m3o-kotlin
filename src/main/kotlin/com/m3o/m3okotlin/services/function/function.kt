
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "function"

object FunctionService {
    suspend fun call(name: String): FunctionCallResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Call")) {
          body = FunctionCallRequest(name)
        }
    }
    suspend fun delete(name: String): FunctionDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = FunctionDeleteRequest(name)
        }
    }
    suspend fun deploy(name: String): FunctionDeployResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Deploy")) {
          body = FunctionDeployRequest(name)
        }
    }
    suspend fun describe(name: String): FunctionDescribeResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Describe")) {
          body = FunctionDescribeRequest(name)
        }
    }
    suspend fun list(name: String): FunctionListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = FunctionListRequest(name)
        }
    }
    suspend fun logs(name: String): FunctionLogsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Logs")) {
          body = FunctionLogsRequest(name)
        }
    }
    suspend fun proxy(name: String): FunctionProxyResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Proxy")) {
          body = FunctionProxyRequest(name)
        }
    }
    suspend fun regions(name: String): FunctionRegionsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Regions")) {
          body = FunctionRegionsRequest(name)
        }
    }
    suspend fun reserve(name: String): FunctionReserveResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Reserve")) {
          body = FunctionReserveRequest(name)
        }
    }
    suspend fun runtimes(name: String): FunctionRuntimesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Runtimes")) {
          body = FunctionRuntimesRequest(name)
        }
    }
    suspend fun update(name: String): FunctionUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = FunctionUpdateRequest(name)
        }
    }
}
@Serializable
internal data class FunctionCallRequest({/// Name of the function
String? name, /// Request body that will be passed to the function
Map<String, dynamic>? request,})
@Serializable
data class FunctionCallResponse({/// Response body that the function returned
Map<String, dynamic>? response,})
@Serializable
internal data class FunctionDeleteRequest({/// The name of the function
String? name,})
@Serializable
data class FunctionDeleteResponse()
@Serializable
internal data class FunctionDeployRequest({/// runtime/lanaguage of the function e.g php74,
/// nodejs6, nodejs8, nodejs10, nodejs12, nodejs14, nodejs16,
/// dotnet3, java11, ruby26, ruby27, go111, go113, go116,
/// python37, python38, python39
String? runtime, /// inline source code
String? source, /// function name
String? name, /// region to deploy in. defaults to europe-west1
String? region, /// github url for a repo
String? repo, /// optional subfolder path
String? subfolder, /// branch to deploy. defaults to master
String? branch, /// entry point, ie. handler name in the source code
/// if not provided, defaults to the name parameter
String? entrypoint, /// environment variables to pass in at runtime
Map<String, String>? env_vars,})
@Serializable
data class FunctionDeployResponse({Func? function,})
@Serializable
internal data class FunctionDescribeRequest({/// The name of the function
String? name,})
@Serializable
data class FunctionDescribeResponse({/// The function requested
Func? function,})
@Serializable
internal data class FunctionFunc({/// time of creation
String? created, /// associated env vars
Map<String, String>? env_vars, /// git repo address
String? repo, /// subfolder path to entrypoint
String? subfolder, /// name of handler in source code
String? entrypoint, /// function name
/// limitation: must be unique across projects
String? name, /// runtime/language of the function e.g php74,
/// nodejs6, nodejs8, nodejs10, nodejs12, nodejs14, nodejs16,
/// dotnet3, java11, ruby26, ruby27, go111, go113, go116,
/// python37, python38, python39
String? runtime, /// time it was updated
String? updated, /// unique url of the function
String? url, /// branch to deploy. defaults to master
String? branch, /// eg. ACTIVE, DEPLOY_IN_PROGRESS, OFFLINE etc
String? status, /// id of the function
String? id, /// region to deploy in. defaults to europe-west1
String? region, /// the source code
String? source,})
@Serializable
internal data class FunctionListRequest()
@Serializable
data class FunctionListResponse({/// List of functions deployed
List<Func>? functions,})
@Serializable
internal data class FunctionLogsRequest({/// type of logs to retrieve, currently supported options - "build"
String? logs_type, /// the name of the function
String? name,})
@Serializable
data class FunctionLogsResponse({String? logs,})
@Serializable
internal data class FunctionProxyRequest({/// id of the function
String? id,})
@Serializable
data class FunctionProxyResponse({/// backend url
String? url,})
@Serializable
internal data class FunctionRegionsRequest()
@Serializable
data class FunctionRegionsResponse({List<String>? regions,})
@Serializable
internal data class FunctionReservation({/// time reservation expires
String? expires, /// name of the app
String? name, /// owner id
String? owner, /// associated token
String? token, /// time of reservation
String? created,})
@Serializable
internal data class FunctionReserveRequest({/// name of your app e.g helloworld
String? name,})
@Serializable
data class FunctionReserveResponse({/// The app reservation
Reservation? reservation,})
@Serializable
internal data class FunctionRuntimesRequest()
@Serializable
data class FunctionRuntimesResponse({List<String>? runtimes,})
@Serializable
internal data class FunctionUpdateRequest({/// function name
String? name, /// inline source code
String? source,})
@Serializable
data class FunctionUpdateResponse()
