
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
      suspend fun timeline(req: TwitterTimelineRequest): TwitterTimelineResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Timeline")) {
          body = req
        }
      }
      suspend fun trends(): TwitterTrendsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Trends")) 
      }
      suspend fun user(req: TwitterUserRequest): TwitterUserResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "User")) {
          body = req
        }
      }
}
@Serializable
data class TwitterProfile(val location: String, val name: String, val private: Boolean, val username: String, val created_at: String, val description: String, val followers: Long, val id: Long, val image_url: String, val verified: Boolean)
@Serializable
data class TwitterSearchRequest(val query: String, val limit: Int)
@Serializable
data class TwitterSearchResponse(val tweets: List<TwitterTweet>)
@Serializable
data class TwitterTimelineRequest(val username: String, val limit: Int)
@Serializable
data class TwitterTimelineResponse(val tweets: List<TwitterTweet>)
@Serializable
data class TwitterTrend(val name: String, val tweet_volume: Long, val url: String)
@Serializable
data class TwitterTrendsResponse(val trends: List<TwitterTrend>)
@Serializable
data class TwitterTweet(val retweeted_count: Long, val text: String, val username: String, val created_at: String, val favourited_count: Long, val id: Long)
@Serializable
data class TwitterUserRequest(val username: String)
@Serializable
data class TwitterUserResponse(val profile: TwitterProfile, val status: TwitterTweet)
