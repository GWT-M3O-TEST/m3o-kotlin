
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "carbon"

object CarbonService {
    suspend fun offset(name: String): CarbonOffsetResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Offset")) {
          body = CarbonOffsetRequest(name)
        }
    }
}
@Serializable
internal data class CarbonOffsetRequest()
@Serializable
data class CarbonOffsetResponse({/// number of tonnes
double? tonnes, /// number of units purchased
int? units, /// the metric used e.g KG or Tonnes
String? metric, /// projects it was allocated to
List<Project>? projects,})
@Serializable
internal data class CarbonProject({/// percentage that went to this
double? percentage, /// amount in tonnes
double? tonnes, /// name of the project
String? name,})
