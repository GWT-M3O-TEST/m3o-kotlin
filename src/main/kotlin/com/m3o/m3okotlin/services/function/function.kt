
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
}
    suspend fun delete(req: FunctionDeleteRequest){
      return ktorHttpClient.post(getUrl(SERVICE, "Delete")) {
        body = req
      }
    }
}
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
    suspend fun deploy(req: FunctionDeployRequest): FunctionDeployResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Deploy")) {
          body = req
        }
    }
}
    suspend fun describe(req: FunctionDescribeRequest): FunctionDescribeResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Describe")) {
          body = req
        }
    }
}
    suspend fun list(): FunctionListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) 
    }
}
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
    suspend fun logs(req: FunctionLogsRequest): FunctionLogsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Logs")) {
          body = req
        }
    }
}
    suspend fun proxy(req: FunctionProxyRequest): FunctionProxyResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Proxy")) {
          body = req
        }
    }
}
    suspend fun regions(): FunctionRegionsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Regions")) 
    }
}
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
    suspend fun reserve(req: FunctionReserveRequest): FunctionReserveResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Reserve")) {
          body = req
        }
    }
}
    suspend fun runtimes(): FunctionRuntimesResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Runtimes")) 
    }
}
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
    suspend fun update(req: FunctionUpdateRequest){
      return ktorHttpClient.post(getUrl(SERVICE, "Update")) {
        body = req
      }
    }
}
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
// generate nothing
