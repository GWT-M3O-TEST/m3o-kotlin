
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
internal data class NftAsset(val creator: NftUser, val image_url: String, val permalink: String, val presale: Boolean, val sales: Int, val id: Int, val owner: NftUser, val collection: NftCollection, val contract: NftContract, val description: String, val last_sale: NftSale, val name: String, val token_id: String, val listing_date: String, val traits: List<NftMap<String, dynamic>>)
@Serializable
internal data class NftAssetRequest(val contract_address: String, val token_id: String)
@Serializable
data class NftAssetResponse(val asset: NftAsset)
@Serializable
internal data class NftAssetsRequest(val cursor: String, val limit: Int, val offset: Int, val order: String, val order_by: String, val collection: String)
@Serializable
data class NftAssetsResponse(val assets: List<NftAsset>, val next: String, val previous: String)
@Serializable
internal data class NftCollection(val editors: List<NftString>, val name: String, val payment_tokens: List<NftToken>, val slug: String, val traits: NftMap<String, dynamic>, val created_at: String, val description: String, val external_link: String, val image_url: String, val payout_address: String, val primary_asset_contracts: List<NftContract>, val stats: NftMap<String, dynamic>, val banner_image_url: String, val safelist_request_status: String, val seller_fees: String)
@Serializable
internal data class NftCollectionRequest(val slug: String)
@Serializable
data class NftCollectionResponse(val collection: NftCollection)
@Serializable
internal data class NftCollectionsRequest(val limit: Int, val offset: Int)
@Serializable
data class NftCollectionsResponse(val collections: List<NftCollection>)
@Serializable
internal data class NftContract(val description: String, val name: String, val owner: Int, val payout_address: String, val seller_fees: String, val symbol: String, val address: String, val created_at: String, val schema: String, val type: String)
@Serializable
internal data class NftCreateRequest(val data: String, val description: String, val image: String, val name: String)
@Serializable
data class NftCreateResponse(val asset: NftAsset)
@Serializable
internal data class NftSale(val asset_token_id: String, val created_at: String, val event_type: String, val quantity: String, val asset_decimals: Int, val payment_token: NftToken, val total_price: String, val transaction: NftTransaction, val event_timestamp: String)
@Serializable
internal data class NftToken(val symbol: String, val usd_price: String, val address: String, val decimals: Int, val eth_price: String, val id: Int, val image_url: String, val name: String)
@Serializable
internal data class NftTransaction(val block_hash: String, val block_number: String, val from_account: NftUser, val id: Int, val timestamp: String, val to_account: NftUser, val transaction_hash: String, val transaction_index: String)
@Serializable
internal data class NftUser(val address: String, val profile_url: String, val username: String)
