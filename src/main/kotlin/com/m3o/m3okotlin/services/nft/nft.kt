
package com.m3o.m3okotlin.services.nft

import com.m3o.m3okotlin.M3O.getUrl
import com.m3o.m3okotlin.M3O.ktorHttpClient

import io.ktor.client.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

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
data class NftAsset(val sales: Int, val traits: List<JsonObject>, val contract: NftContract, val image_url: String, val listing_date: String, val name: String, val owner: NftUser, val permalink: String, val collection: NftCollection, val last_sale: NftSale, val presale: Boolean, val creator: NftUser, val token_id: String, val description: String, val id: Int)
@Serializable
data class NftAssetRequest(val contract_address: String, val token_id: String)
@Serializable
data class NftAssetResponse(val asset: NftAsset)
@Serializable
data class NftAssetsRequest(val order: String, val order_by: String, val owner: String, val collection: String, val cursor: String, val limit: Int, val offset: Int)
@Serializable
data class NftAssetsResponse(val previous: String, val assets: List<NftAsset>, val next: String)
@Serializable
data class NftCollection(val safelist_request_status: String, val seller_fees: String, val banner_image_url: String, val external_link: String, val image_url: String, val payment_tokens: List<NftToken>, val payout_address: String, val editors: List<String>, val primary_asset_contracts: List<NftContract>, val stats: JsonObject, val traits: JsonObject, val created_at: String, val description: String, val name: String, val slug: String)
@Serializable
data class NftCollectionRequest(val slug: String)
@Serializable
data class NftCollectionResponse(val collection: NftCollection)
@Serializable
data class NftCollectionsRequest(val limit: Int, val offset: Int, val owner: String)
@Serializable
data class NftCollectionsResponse(val collections: List<NftCollection>)
@Serializable
data class NftContract(val payout_address: String, val schema: String, val symbol: String, val address: String, val created_at: String, val description: String, val name: String, val owner: Int, val seller_fees: String, val type: String)
@Serializable
data class NftCreateRequest(val image: String, val name: String, val data: String, val description: String)
@Serializable
data class NftCreateResponse(val asset: NftAsset)
@Serializable
data class NftSale(val created_at: String, val event_timestamp: String, val payment_token: NftToken, val quantity: String, val total_price: String, val transaction: NftTransaction, val asset_decimals: Int, val event_type: String, val asset_token_id: String)
@Serializable
data class NftToken(val id: Int, val image_url: String, val name: String, val symbol: String, val usd_price: String, val address: String, val decimals: Int, val eth_price: String)
@Serializable
data class NftTransaction(val transaction_hash: String, val transaction_index: String, val block_hash: String, val block_number: String, val from_account: NftUser, val id: Int, val timestamp: String, val to_account: NftUser)
@Serializable
data class NftUser(val profile_url: String, val username: String, val address: String)
