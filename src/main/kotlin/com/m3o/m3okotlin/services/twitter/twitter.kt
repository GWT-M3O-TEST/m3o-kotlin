
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
internal data class TwitterProfile({/// display name of the user
String? name, /// if the account is private
bool? private, /// if the account is verified
bool? verified, /// the account creation date
String? created_at, /// the user description
String? description, /// the follower count

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? followers
	, /// the user id

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? id
	, /// The user's profile picture
String? image_url, /// the user's location
String? location, /// the username
String? username,})
@Serializable
internal data class TwitterSearchRequest({/// number of tweets to return. default: 20
int? limit, /// the query to search for
String? query,})
@Serializable
data class TwitterSearchResponse({/// the related tweets for the search
List<Tweet>? tweets,})
@Serializable
internal data class TwitterTimelineRequest({/// number of tweets to return. default: 20
int? limit, /// the username to request the timeline for
String? username,})
@Serializable
data class TwitterTimelineResponse({/// The recent tweets for the user
List<Tweet>? tweets,})
@Serializable
internal data class TwitterTrend({/// name of the trend
String? name, /// the volume of tweets in last 24 hours

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? tweet_volume
	, /// the twitter url
String? url,})
@Serializable
internal data class TwitterTrendsRequest()
@Serializable
data class TwitterTrendsResponse({/// a list of trending topics
List<Trend>? trends,})
@Serializable
internal data class TwitterTweet({/// number of times favourited

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? favourited_count
	, /// id of the tweet

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? id
	, /// number of times retweeted

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? retweeted_count
	, /// text of the tweet
String? text, /// username of the person who tweeted
String? username, /// time of tweet
String? created_at,})
@Serializable
internal data class TwitterUserRequest({/// the username to lookup
String? username,})
@Serializable
data class TwitterUserResponse({/// The requested user profile
Profile? profile, /// the current user status
Tweet? status,})
