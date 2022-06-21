
package com.m3o.m3okotlin.services.twitter

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "twitter"

object TwitterService {
    suspend fun search(req: TwitterSearchRequest): TwitterSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = req
        }
    }
}
    suspend fun timeline(req: TwitterTimelineRequest): TwitterTimelineResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Timeline")) {
          body = req
        }
    }
}
    suspend fun trends(): TwitterTrendsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Trends")) 
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
    suspend fun user(req: TwitterUserRequest): TwitterUserResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "User")) {
          body = req
        }
    }
}
