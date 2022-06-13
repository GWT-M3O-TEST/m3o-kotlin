
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
    suspend fun list(req: UrlListRequest): UrlListResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "List")) {
          body = req
        }
    }
    suspend fun proxy(req: UrlProxyRequest): UrlProxyResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Proxy")) {
          body = req
        }
    }
    suspend fun shorten(req: UrlShortenRequest): UrlShortenResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Shorten")) {
          body = req
        }
    }
}
@Serializable
internal data class UrlListRequest(val shortURL: String)
@Serializable
data class UrlListResponse(val urlPairs: UrlURLPair)
@Serializable
internal data class UrlProxyRequest(val shortURL: String)
@Serializable
data class UrlProxyResponse(val destinationURL: String)
@Serializable
internal data class UrlShortenRequest(val destinationURL: String)
@Serializable
data class UrlShortenResponse(val shortURL: String)
@Serializable
internal data class UrlURLPair(val created: String, val destinationURL: String, val hitCount: Long, val shortURL: String)
