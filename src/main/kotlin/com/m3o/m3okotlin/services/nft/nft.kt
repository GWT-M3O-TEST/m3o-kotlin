
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
internal data class NftAsset(val collection: NftCollection, val last_sale: NftSale, val presale: Boolean, val listing_date: String, val owner: NftUser, val permalink: String, val sales: Int, val token_id: String, val traits: List<NftMap<String, dynamic>>, val creator: NftUser, val description: String, val name: String, val contract: NftContract, val id: Int, val image_url: String)
@Serializable
internal data class NftAssetRequest(val contract_address: String, val token_id: String)
@Serializable
data class NftAssetResponse(val asset: NftAsset)
@Serializable
internal data class NftAssetsRequest(val collection: String, val cursor: String, val limit: Int, val offset: Int, val order: String, val order_by: String)
@Serializable
data class NftAssetsResponse(val assets: List<NftAsset>, val next: String, val previous: String)
@Serializable
internal data class NftCollection(val created_at: String, val editors: List<NftString>, val external_link: String, val image_url: String, val name: String, val safelist_request_status: String, val payment_tokens: List<NftToken>, val primary_asset_contracts: List<NftContract>, val slug: String, val description: String, val payout_address: String, val seller_fees: String, val stats: NftMap<String, dynamic>, val banner_image_url: String, val traits: NftMap<String, dynamic>)
@Serializable
internal data class NftCollectionRequest(val slug: String)
@Serializable
data class NftCollectionResponse(val collection: NftCollection)
@Serializable
internal data class NftCollectionsRequest(val limit: Int, val offset: Int)
@Serializable
data class NftCollectionsResponse(val collections: List<NftCollection>)
@Serializable
internal data class NftContract(val description: String, val address: String, val name: String, val owner: Int, val payout_address: String, val schema: String, val seller_fees: String, val symbol: String, val type: String, val created_at: String)
@Serializable
internal data class NftCreateRequest(val name: String, val data: String, val description: String, val image: String)
@Serializable
data class NftCreateResponse(val asset: NftAsset)
@Serializable
internal data class NftSale(val asset_token_id: String, val event_timestamp: String, val payment_token: NftToken, val quantity: String, val transaction: NftTransaction, val asset_decimals: Int, val event_type: String, val total_price: String, val created_at: String)
@Serializable
internal data class NftToken(val eth_price: String, val id: Int, val image_url: String, val name: String, val symbol: String, val usd_price: String, val address: String, val decimals: Int)
@Serializable
internal data class NftTransaction(val to_account: NftUser, val transaction_hash: String, val transaction_index: String, val block_hash: String, val block_number: String, val from_account: NftUser, val id: Int, val timestamp: String)
@Serializable
internal data class NftUser(val address: String, val profile_url: String, val username: String)
