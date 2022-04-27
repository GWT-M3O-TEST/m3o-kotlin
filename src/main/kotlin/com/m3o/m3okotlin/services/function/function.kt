
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
internal data class FunctionCallRequest(val name: String, val request: FunctionMap<String, dynamic>)
@Serializable
data class FunctionCallResponse(val response: FunctionMap<String, dynamic>)
@Serializable
internal data class FunctionDeleteRequest(val name: String)
@Serializable
data class FunctionDeleteResponse()
@Serializable
internal data class FunctionDeployRequest(val branch: String, val entrypoint: String, val repo: String, val runtime: String, val source: String, val env_vars: Map<String, String>, val name: String, val region: String, val subfolder: String)
@Serializable
data class FunctionDeployResponse(val function: FunctionFunc)
@Serializable
internal data class FunctionDescribeRequest(val name: String)
@Serializable
data class FunctionDescribeResponse(val function: FunctionFunc)
@Serializable
internal data class FunctionFunc(val url: String, val id: String, val repo: String, val source: String, val status: String, val updated: String, val branch: String, val runtime: String, val name: String, val subfolder: String, val env_vars: Map<String, String>, val region: String, val created: String, val entrypoint: String)
@Serializable
internal data class FunctionListRequest()
@Serializable
data class FunctionListResponse(val functions: List<FunctionFunc>)
@Serializable
internal data class FunctionLogsRequest(val logs_type: String, val name: String)
@Serializable
data class FunctionLogsResponse(val logs: String)
@Serializable
internal data class FunctionProxyRequest(val id: String)
@Serializable
data class FunctionProxyResponse(val url: String)
@Serializable
internal data class FunctionRegionsRequest()
@Serializable
data class FunctionRegionsResponse(val regions: List<FunctionString>)
@Serializable
internal data class FunctionReservation(val owner: String, val token: String, val created: String, val expires: String, val name: String)
@Serializable
internal data class FunctionReserveRequest(val name: String)
@Serializable
data class FunctionReserveResponse(val reservation: FunctionReservation)
@Serializable
internal data class FunctionRuntimesRequest()
@Serializable
data class FunctionRuntimesResponse(val runtimes: List<FunctionString>)
@Serializable
internal data class FunctionUpdateRequest(val name: String, val source: String)
@Serializable
data class FunctionUpdateResponse()
