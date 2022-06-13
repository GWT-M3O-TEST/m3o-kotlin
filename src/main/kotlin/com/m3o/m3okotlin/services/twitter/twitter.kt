
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
    suspend fun search(req: TwitterSearchRequest): TwitterSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
          body = req
        }
    }
    suspend fun timeline(req: TwitterTimelineRequest): TwitterTimelineResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Timeline")) {
          body = req
        }
    }
    suspend fun trends(req: TwitterTrendsRequest): TwitterTrendsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Trends")) {
          body = req
        }
    }
    suspend fun user(req: TwitterUserRequest): TwitterUserResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "User")) {
          body = req
        }
    }
}
@Serializable
internal data class TwitterProfile(val description: String, val image_url: String, val name: String, val private: Boolean, val username: String, val verified: Boolean, val created_at: String, val followers: Long, val id: Long, val location: String)
@Serializable
internal data class TwitterSearchRequest(val limit: Int, val query: String)
@Serializable
data class TwitterSearchResponse(val tweets: List<TwitterTweet>)
@Serializable
internal data class TwitterTimelineRequest(val limit: Int, val username: String)
@Serializable
data class TwitterTimelineResponse(val tweets: List<TwitterTweet>)
@Serializable
internal data class TwitterTrend(val name: String, val tweet_volume: Long, val url: String)
@Serializable
internal data class TwitterTrendsRequest()
@Serializable
data class TwitterTrendsResponse(val trends: List<TwitterTrend>)
@Serializable
internal data class TwitterTweet(val retweeted_count: Long, val text: String, val username: String, val created_at: String, val favourited_count: Long, val id: Long)
@Serializable
internal data class TwitterUserRequest(val username: String)
@Serializable
data class TwitterUserResponse(val profile: TwitterProfile, val status: TwitterTweet)
