
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
    suspend fun call(req: FunctionCallRequest): FunctionCallResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Call")) {
          body = req
        }
    }
    suspend fun delete(req: FunctionDeleteRequest): FunctionDeleteResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
          body = req
        }
    }
    suspend fun deploy(req: FunctionDeployRequest): FunctionDeployResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Deploy")) {
          body = req
        }
    }
    suspend fun describe(req: FunctionDescribeRequest): FunctionDescribeResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Describe")) {
          body = req
        }
    }
    suspend fun list(req: FunctionListRequest): FunctionListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = req
        }
    }
    suspend fun logs(req: FunctionLogsRequest): FunctionLogsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Logs")) {
          body = req
        }
    }
    suspend fun proxy(req: FunctionProxyRequest): FunctionProxyResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Proxy")) {
          body = req
        }
    }
    suspend fun regions(req: FunctionRegionsRequest): FunctionRegionsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Regions")) {
          body = req
        }
    }
    suspend fun reserve(req: FunctionReserveRequest): FunctionReserveResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Reserve")) {
          body = req
        }
    }
    suspend fun runtimes(req: FunctionRuntimesRequest): FunctionRuntimesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Runtimes")) {
          body = req
        }
    }
    suspend fun update(req: FunctionUpdateRequest): FunctionUpdateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = req
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
internal data class FunctionDeployRequest(val source: String, val branch: String, val repo: String, val runtime: String, val region: String, val subfolder: String, val entrypoint: String, val env_vars: Map<String, String>, val name: String)
@Serializable
data class FunctionDeployResponse(val function: FunctionFunc)
@Serializable
internal data class FunctionDescribeRequest(val name: String)
@Serializable
data class FunctionDescribeResponse(val function: FunctionFunc)
@Serializable
internal data class FunctionFunc(val id: String, val entrypoint: String, val branch: String, val env_vars: Map<String, String>, val name: String, val repo: String, val subfolder: String, val url: String, val created: String, val region: String, val runtime: String, val source: String, val status: String, val updated: String)
@Serializable
internal data class FunctionListRequest()
@Serializable
data class FunctionListResponse(val functions: List<FunctionFunc>)
@Serializable
internal data class FunctionLogsRequest(val name: String, val logs_type: String)
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
internal data class FunctionReservation(val created: String, val expires: String, val name: String, val owner: String, val token: String)
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
