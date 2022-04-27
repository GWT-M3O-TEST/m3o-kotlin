
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
internal data class NftAsset(val sales: Int, val token_id: String, val description: String, val last_sale: NftSale, val listing_date: String, val owner: NftUser, val presale: Boolean, val traits: List<NftMap<String, dynamic>>, val collection: NftCollection, val contract: NftContract, val creator: NftUser, val id: Int, val name: String, val image_url: String, val permalink: String)
@Serializable
internal data class NftAssetRequest(val contract_address: String, val token_id: String)
@Serializable
data class NftAssetResponse(val asset: NftAsset)
@Serializable
internal data class NftAssetsRequest(val collection: String, val cursor: String, val limit: Int, val offset: Int, val order: String, val order_by: String)
@Serializable
data class NftAssetsResponse(val assets: List<NftAsset>, val next: String, val previous: String)
@Serializable
internal data class NftCollection(val image_url: String, val traits: NftMap<String, dynamic>, val banner_image_url: String, val created_at: String, val payment_tokens: List<NftToken>, val payout_address: String, val primary_asset_contracts: List<NftContract>, val slug: String, val description: String, val editors: List<NftString>, val external_link: String, val safelist_request_status: String, val seller_fees: String, val name: String, val stats: NftMap<String, dynamic>)
@Serializable
internal data class NftCollectionRequest(val slug: String)
@Serializable
data class NftCollectionResponse(val collection: NftCollection)
@Serializable
internal data class NftCollectionsRequest(val limit: Int, val offset: Int)
@Serializable
data class NftCollectionsResponse(val collections: List<NftCollection>)
@Serializable
internal data class NftContract(val address: String, val created_at: String, val owner: Int, val payout_address: String, val schema: String, val symbol: String, val type: String, val description: String, val name: String, val seller_fees: String)
@Serializable
internal data class NftCreateRequest(val data: String, val description: String, val image: String, val name: String)
@Serializable
data class NftCreateResponse(val asset: NftAsset)
@Serializable
internal data class NftSale(val asset_decimals: Int, val payment_token: NftToken, val quantity: String, val total_price: String, val asset_token_id: String, val created_at: String, val event_timestamp: String, val event_type: String, val transaction: NftTransaction)
@Serializable
internal data class NftToken(val image_url: String, val name: String, val symbol: String, val usd_price: String, val address: String, val decimals: Int, val eth_price: String, val id: Int)
@Serializable
internal data class NftTransaction(val from_account: NftUser, val id: Int, val timestamp: String, val to_account: NftUser, val transaction_hash: String, val transaction_index: String, val block_hash: String, val block_number: String)
@Serializable
internal data class NftUser(val profile_url: String, val username: String, val address: String)
