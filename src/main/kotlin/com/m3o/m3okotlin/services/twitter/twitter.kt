
package com.m3o.m3okotlin.services.twitter

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "twitter"

object TwitterServ {
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
data class TwitterProfile(val image_url: String? = null, val location: String? = null, val username: String? = null, val verified: Boolean? = null, val created_at: String? = null, val followers: Long? = null, val name: String? = null, val private: Boolean? = null, val description: String? = null, val id: Long? = null)
@Serializable
data class TwitterSearchRequest(val limit: Int? = null, val query: String? = null)
@Serializable
data class TwitterSearchResponse(val tweets: List<TwitterTweet>? = null)
@Serializable
data class TwitterTimelineRequest(val limit: Int? = null, val username: String? = null)
@Serializable
data class TwitterTimelineResponse(val tweets: List<TwitterTweet>? = null)
@Serializable
data class TwitterTrend(val tweet_volume: Long? = null, val url: String? = null, val name: String? = null)
@Serializable
data class TwitterTrendsResponse(val trends: List<TwitterTrend>? = null)
@Serializable
data class TwitterTweet(val username: String? = null, val created_at: String? = null, val favourited_count: Long? = null, val id: Long? = null, val retweeted_count: Long? = null, val text: String? = null)
@Serializable
data class TwitterUserRequest(val username: String? = null)
@Serializable
data class TwitterUserResponse(val profile: TwitterProfile? = null, val status: TwitterTweet? = null)
