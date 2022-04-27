
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
internal data class FunctionCallRequest()
@Serializable
data class FunctionCallResponse()
@Serializable
internal data class FunctionDeleteRequest()
@Serializable
data class FunctionDeleteResponse()
@Serializable
internal data class FunctionDeployRequest()
@Serializable
data class FunctionDeployResponse()
@Serializable
internal data class FunctionDescribeRequest()
@Serializable
data class FunctionDescribeResponse()
@Serializable
internal data class FunctionFunc()
@Serializable
internal data class FunctionListRequest()
@Serializable
data class FunctionListResponse()
@Serializable
internal data class FunctionLogsRequest()
@Serializable
data class FunctionLogsResponse()
@Serializable
internal data class FunctionProxyRequest()
@Serializable
data class FunctionProxyResponse()
@Serializable
internal data class FunctionRegionsRequest()
@Serializable
data class FunctionRegionsResponse()
@Serializable
internal data class FunctionReservation()
@Serializable
internal data class FunctionReserveRequest()
@Serializable
data class FunctionReserveResponse()
@Serializable
internal data class FunctionRuntimesRequest()
@Serializable
data class FunctionRuntimesResponse()
@Serializable
internal data class FunctionUpdateRequest()
@Serializable
data class FunctionUpdateResponse()
