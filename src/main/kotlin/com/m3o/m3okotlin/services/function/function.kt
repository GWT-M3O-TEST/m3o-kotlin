
package com.m3o.m3okotlin.services.function

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "function"

object FunctionServ {
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
data class FunctionCallRequest(val name: String? = null, val request: JsonObject? = null)
@Serializable
data class FunctionCallResponse(val response: JsonObject? = null)
@Serializable
data class FunctionDeleteRequest(val name: String? = null)
@Serializable
data class FunctionDeployRequest(val entrypoint: String? = null, val name: String? = null, val repo: String? = null, val branch: String? = null, val region: String? = null, val runtime: String? = null, val source: String? = null, val subfolder: String? = null, val env_vars: Map<String, String>? = null)
@Serializable
data class FunctionDeployResponse(val function: FunctionFunc? = null)
@Serializable
data class FunctionDescribeRequest(val name: String? = null)
@Serializable
data class FunctionDescribeResponse(val function: FunctionFunc? = null)
@Serializable
data class FunctionFunc(val url: String? = null, val branch: String? = null, val source: String? = null, val repo: String? = null, val runtime: String? = null, val updated: String? = null, val created: String? = null, val name: String? = null, val region: String? = null, val status: String? = null, val subfolder: String? = null, val env_vars: Map<String, String>? = null, val id: String? = null, val entrypoint: String? = null)
@Serializable
data class FunctionListResponse(val functions: List<FunctionFunc>? = null)
@Serializable
data class FunctionLogsRequest(val logs_type: String? = null, val name: String? = null)
@Serializable
data class FunctionLogsResponse(val logs: String? = null)
@Serializable
data class FunctionProxyRequest(val id: String? = null)
@Serializable
data class FunctionProxyResponse(val url: String? = null)
@Serializable
data class FunctionRegionsResponse(val regions: List<String>? = null)
@Serializable
data class FunctionReservation(val name: String? = null, val owner: String? = null, val token: String? = null, val created: String? = null, val expires: String? = null)
@Serializable
data class FunctionReserveRequest(val name: String? = null)
@Serializable
data class FunctionReserveResponse(val reservation: FunctionReservation? = null)
@Serializable
data class FunctionRuntimesResponse(val runtimes: List<String>? = null)
@Serializable
data class FunctionUpdateRequest(val name: String? = null, val source: String? = null)
