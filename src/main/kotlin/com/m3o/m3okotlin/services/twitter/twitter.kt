
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "twitter"

object TwitterService {
    suspend fun search(name: String): TwitterSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = TwitterSearchRequest(name)
        }
    }
    suspend fun timeline(name: String): TwitterTimelineResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Timeline")) {
          body = TwitterTimelineRequest(name)
        }
    }
    suspend fun trends(name: String): TwitterTrendsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Trends")) {
          body = TwitterTrendsRequest(name)
        }
    }
    suspend fun user(name: String): TwitterUserResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "User")) {
          body = TwitterUserRequest(name)
        }
    }
}
@Serializable
internal data class TwitterProfile()
@Serializable
internal data class TwitterSearchRequest()
@Serializable
data class TwitterSearchResponse()
@Serializable
internal data class TwitterTimelineRequest()
@Serializable
data class TwitterTimelineResponse()
@Serializable
internal data class TwitterTrend()
@Serializable
internal data class TwitterTrendsRequest()
@Serializable
data class TwitterTrendsResponse()
@Serializable
internal data class TwitterTweet()
@Serializable
internal data class TwitterUserRequest()
@Serializable
data class TwitterUserResponse()
