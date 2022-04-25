
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "rss"

object RssService {
    suspend fun add(name: String): RssAddResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Add")) {
          body = RssAddRequest(name)
        }
    }
    suspend fun feed(name: String): RssFeedResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Feed")) {
          body = RssFeedRequest(name)
        }
    }
    suspend fun list(name: String): RssListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = RssListRequest(name)
        }
    }
    suspend fun remove(name: String): RssRemoveResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Remove")) {
          body = RssRemoveRequest(name)
        }
    }
}
@Serializable
internal data class RssAddRequest({/// rss feed url
/// eg. http://a16z.com/feed/
String? url, /// category to add e.g news
String? category, /// rss feed name
/// eg. a16z
String? name,})
@Serializable
data class RssAddResponse()
@Serializable
internal data class RssEntry({/// article summary
String? summary, /// title of the entry
String? title, /// article content
String? content, /// data of the entry
String? date, /// the rss feed where it came from
String? feed, /// unique id of the entry
String? id, /// rss feed url of the entry
String? link,})
@Serializable
internal data class RssFeed({/// rss feed url
/// eg. http://a16z.com/feed/
String? url, /// category of the feed e.g news
String? category, /// unique id
String? id, /// rss feed name
/// eg. a16z
String? name,})
@Serializable
internal data class RssFeedRequest({/// limit entries returned

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? limit
	, /// rss feed name
String? name, /// offset entries

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? offset
	,})
@Serializable
data class RssFeedResponse({List<Entry>? entries,})
@Serializable
internal data class RssListRequest()
@Serializable
data class RssListResponse({List<Feed>? feeds,})
@Serializable
internal data class RssRemoveRequest({/// rss feed name
/// eg. a16z
String? name,})
@Serializable
data class RssRemoveResponse()
