
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
internal data class TwitterProfile(val image_url: String, val name: String, val verified: Boolean, val description: String, val followers: Long, val id: Long, val username: String, val created_at: String, val location: String, val private: Boolean)
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
internal data class TwitterTweet(val created_at: String, val favourited_count: Long, val id: Long, val retweeted_count: Long, val text: String, val username: String)
@Serializable
internal data class TwitterUserRequest(val username: String)
@Serializable
data class TwitterUserResponse(val profile: TwitterProfile, val status: TwitterTweet)
