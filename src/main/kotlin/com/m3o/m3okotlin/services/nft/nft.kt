
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
data class NftAsset(val id: Int, val name: String, val owner: NftUser, val traits: List<Map<String, Any>>, val creator: NftUser, val collection: NftCollection, val contract: NftContract, val description: String, val listing_date: String, val image_url: String, val last_sale: NftSale, val permalink: String, val presale: Boolean, val sales: Int, val token_id: String)
@Serializable
data class NftAssetRequest(val contract_address: String, val token_id: String)
@Serializable
data class NftAssetResponse(val asset: NftAsset)
@Serializable
data class NftAssetsRequest(val order_by: String, val collection: String, val cursor: String, val limit: Int, val offset: Int, val order: String)
@Serializable
data class NftAssetsResponse(val assets: List<NftAsset>, val next: String, val previous: String)
@Serializable
data class NftCollection(val description: String, val editors: List<String>, val name: String, val payment_tokens: List<NftToken>, val banner_image_url: String, val external_link: String, val primary_asset_contracts: List<NftContract>, val payout_address: String, val slug: String, val stats: Map<String, Any>, val traits: Map<String, Any>, val created_at: String, val image_url: String, val safelist_request_status: String, val seller_fees: String)
@Serializable
data class NftCollectionRequest(val slug: String)
@Serializable
data class NftCollectionResponse(val collection: NftCollection)
@Serializable
data class NftCollectionsRequest(val limit: Int, val offset: Int)
@Serializable
data class NftCollectionsResponse(val collections: List<NftCollection>)
@Serializable
data class NftContract(val created_at: String, val schema: String, val type: String, val address: String, val name: String, val owner: Int, val payout_address: String, val seller_fees: String, val symbol: String, val description: String)
@Serializable
data class NftCreateRequest(val data: String, val description: String, val image: String, val name: String)
@Serializable
data class NftCreateResponse(val asset: NftAsset)
@Serializable
data class NftSale(val asset_token_id: String, val created_at: String, val event_type: String, val payment_token: NftToken, val asset_decimals: Int, val quantity: String, val total_price: String, val transaction: NftTransaction, val event_timestamp: String)
@Serializable
data class NftToken(val image_url: String, val name: String, val symbol: String, val usd_price: String, val address: String, val decimals: Int, val eth_price: String, val id: Int)
@Serializable
data class NftTransaction(val from_account: NftUser, val id: Int, val timestamp: String, val to_account: NftUser, val transaction_hash: String, val transaction_index: String, val block_hash: String, val block_number: String)
@Serializable
data class NftUser(val address: String, val profile_url: String, val username: String)
