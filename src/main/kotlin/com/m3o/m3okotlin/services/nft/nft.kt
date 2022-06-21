
package com.m3o.m3okotlin.services.nft

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

private const val SERVICE = "nft"

object NftService {
    suspend fun asset(req: NftAssetRequest): NftAssetResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Asset")) {
          body = req
        }
    }
}
    suspend fun assets(req: NftAssetsRequest): NftAssetsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Assets")) {
          body = req
        }
    }
}
    suspend fun collection(req: NftCollectionRequest): NftCollectionResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Collection")) {
          body = req
        }
    }
}
    suspend fun collections(req: NftCollectionsRequest): NftCollectionsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Collections")) {
          body = req
        }
    }
}
    suspend fun create(req: NftCreateRequest): NftCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = req
        }
    }
}
