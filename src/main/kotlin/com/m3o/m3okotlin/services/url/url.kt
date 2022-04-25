
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "url"

object UrlService {
    suspend fun list(name: String): UrlListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = UrlListRequest(name)
        }
    }
    suspend fun proxy(name: String): UrlProxyResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Proxy")) {
          body = UrlProxyRequest(name)
        }
    }
    suspend fun shorten(name: String): UrlShortenResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Shorten")) {
          body = UrlShortenRequest(name)
        }
    }
}
@Serializable
internal data class UrlListRequest({/// filter by short URL, optional
String? shortURL,})
@Serializable
data class UrlListResponse({URLPair? urlPairs,})
@Serializable
internal data class UrlProxyRequest({/// short url ID, without the domain, eg. if your short URL is
/// `m3o.one/u/someshorturlid` then pass in `someshorturlid`
String? shortURL,})
@Serializable
data class UrlProxyResponse({String? destinationURL,})
@Serializable
internal data class UrlShortenRequest({/// the url to shorten
String? destinationURL,})
@Serializable
data class UrlShortenResponse({/// the shortened url
String? shortURL,})
@Serializable
internal data class UrlURLPair({/// time of creation
String? created, /// destination url
String? destinationURL, /// The number of times the short URL has been resolved

	@JsonKey(fromJson: int64FromString, toJson: int64ToString)
	int? hitCount
	, /// shortened url
String? shortURL,})
