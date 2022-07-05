
package com.m3o.m3okotlin.services.function

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
      suspend fun delete(req: FunctionDeleteRequest){
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
      suspend fun list(): FunctionListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) 
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
      suspend fun regions(): FunctionRegionsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Regions")) 
      }
      suspend fun reserve(req: FunctionReserveRequest): FunctionReserveResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Reserve")) {
          body = req
        }
      }
      suspend fun runtimes(): FunctionRuntimesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Runtimes")) 
      }
      suspend fun update(req: FunctionUpdateRequest){
        return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
          body = req
        }
      }
}
@Serializable
data class FunctionCallRequest(val name: String, val request: Map<String, Any>)
@Serializable
data class FunctionCallResponse(val response: Map<String, Any>)
@Serializable
data class FunctionDeleteRequest(val name: String)
@Serializable
data class FunctionDeployRequest(val subfolder: String, val source: String, val entrypoint: String, val env_vars: Map<String, String>, val name: String, val region: String, val repo: String, val runtime: String, val branch: String)
@Serializable
data class FunctionDeployResponse(val function: FunctionFunc)
@Serializable
data class FunctionDescribeRequest(val name: String)
@Serializable
data class FunctionDescribeResponse(val function: FunctionFunc)
@Serializable
data class FunctionFunc(val created: String, val entrypoint: String, val repo: String, val updated: String, val branch: String, val id: String, val runtime: String, val url: String, val env_vars: Map<String, String>, val name: String, val region: String, val source: String, val status: String, val subfolder: String)
@Serializable
data class FunctionListResponse(val functions: List<FunctionFunc>)
@Serializable
data class FunctionLogsRequest(val logs_type: String, val name: String)
@Serializable
data class FunctionLogsResponse(val logs: String)
@Serializable
data class FunctionProxyRequest(val id: String)
@Serializable
data class FunctionProxyResponse(val url: String)
@Serializable
data class FunctionRegionsResponse(val regions: List<String>)
@Serializable
data class FunctionReservation(val created: String, val expires: String, val name: String, val owner: String, val token: String)
@Serializable
data class FunctionReserveRequest(val name: String)
@Serializable
data class FunctionReserveResponse(val reservation: FunctionReservation)
@Serializable
data class FunctionRuntimesResponse(val runtimes: List<String>)
@Serializable
data class FunctionUpdateRequest(val name: String, val source: String)
