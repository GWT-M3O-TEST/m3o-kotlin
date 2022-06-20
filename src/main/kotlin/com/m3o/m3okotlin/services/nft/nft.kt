
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
    suspend fun assets(req: NftAssetsRequest): NftAssetsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Assets")) {
          body = req
        }
    }
    suspend fun collection(req: NftCollectionRequest): NftCollectionResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Collection")) {
          body = req
        }
    }
    suspend fun collections(req: NftCollectionsRequest): NftCollectionsResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Collections")) {
          body = req
        }
    }
    suspend fun create(req: NftCreateRequest): NftCreateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Create")) {
          body = req
        }
    }
}
@Serializable
data class NftAsset(val traits: List<NftMap<String, dynamic>>, val collection: NftCollection, val creator: NftUser, val image_url: String, val presale: Boolean, val description: String, val last_sale: NftSale, val listing_date: String, val id: Int, val sales: Int, val permalink: String, val token_id: String, val contract: NftContract, val name: String, val owner: NftUser)
@Serializable
data class NftAssetRequest(val contract_address: String, val token_id: String)
@Serializable
data class NftAssetResponse(val asset: NftAsset)
@Serializable
data class NftAssetsRequest(val limit: Int, val offset: Int, val order: String, val order_by: String, val collection: String, val cursor: String)
@Serializable
data class NftAssetsResponse(val assets: List<NftAsset>, val next: String, val previous: String)
@Serializable
data class NftCollection(val primary_asset_contracts: List<NftContract>, val seller_fees: String, val slug: String, val traits: NftMap<String, dynamic>, val created_at: String, val editors: List<NftString>, val payment_tokens: List<NftToken>, val payout_address: String, val stats: NftMap<String, dynamic>, val banner_image_url: String, val description: String, val safelist_request_status: String, val name: String, val external_link: String, val image_url: String)
@Serializable
data class NftCollectionRequest(val slug: String)
@Serializable
data class NftCollectionResponse(val collection: NftCollection)
@Serializable
data class NftCollectionsRequest(val limit: Int, val offset: Int)
@Serializable
data class NftCollectionsResponse(val collections: List<NftCollection>)
@Serializable
data class NftContract(val description: String, val name: String, val seller_fees: String, val symbol: String, val type: String, val address: String, val created_at: String, val owner: Int, val payout_address: String, val schema: String)
@Serializable
data class NftCreateRequest(val data: String, val description: String, val image: String, val name: String)
@Serializable
data class NftCreateResponse(val asset: NftAsset)
@Serializable
data class NftSale(val transaction: NftTransaction, val event_type: String, val payment_token: NftToken, val quantity: String, val event_timestamp: String, val total_price: String, val asset_decimals: Int, val asset_token_id: String, val created_at: String)
@Serializable
data class NftToken(val symbol: String, val usd_price: String, val address: String, val decimals: Int, val eth_price: String, val id: Int, val image_url: String, val name: String)
@Serializable
data class NftTransaction(val block_number: String, val from_account: NftUser, val id: Int, val timestamp: String, val to_account: NftUser, val transaction_hash: String, val transaction_index: String, val block_hash: String)
@Serializable
data class NftUser(val address: String, val profile_url: String, val username: String)
