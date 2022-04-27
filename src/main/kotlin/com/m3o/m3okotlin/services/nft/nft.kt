
package com.m3o.m3okotlin.services

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "nft"

object NftService {
    suspend fun asset(name: String): NftAssetResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Asset")) {
          body = NftAssetRequest(name)
        }
    }
    suspend fun assets(name: String): NftAssetsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Assets")) {
          body = NftAssetsRequest(name)
        }
    }
    suspend fun collection(name: String): NftCollectionResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Collection")) {
          body = NftCollectionRequest(name)
        }
    }
    suspend fun collections(name: String): NftCollectionsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Collections")) {
          body = NftCollectionsRequest(name)
        }
    }
    suspend fun create(name: String): NftCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = NftCreateRequest(name)
        }
    }
}
@Serializable
internal data class NftAsset()
@Serializable
internal data class NftAssetRequest()
@Serializable
data class NftAssetResponse()
@Serializable
internal data class NftAssetsRequest()
@Serializable
data class NftAssetsResponse()
@Serializable
internal data class NftCollection()
@Serializable
internal data class NftCollectionRequest()
@Serializable
data class NftCollectionResponse()
@Serializable
internal data class NftCollectionsRequest()
@Serializable
data class NftCollectionsResponse()
@Serializable
internal data class NftContract()
@Serializable
internal data class NftCreateRequest()
@Serializable
data class NftCreateResponse()
@Serializable
internal data class NftSale()
@Serializable
internal data class NftToken()
@Serializable
internal data class NftTransaction()
@Serializable
internal data class NftUser()
