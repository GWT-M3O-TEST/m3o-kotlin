
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

object NftServ {
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
data class NftAsset(val collection: NftCollection? = null, val listing_date: String? = null, val permalink: String? = null, val traits: List<JsonObject>? = null, val contract: NftContract? = null, val description: String? = null, val image_url: String? = null, val owner: NftUser? = null, val id: Int? = null, val last_sale: NftSale? = null, val presale: Boolean? = null, val sales: Int? = null, val creator: NftUser? = null, val name: String? = null, val token_id: String? = null)
@Serializable
data class NftAssetRequest(val contract_address: String? = null, val token_id: String? = null)
@Serializable
data class NftAssetResponse(val asset: NftAsset? = null)
@Serializable
data class NftAssetsRequest(val order: String? = null, val order_by: String? = null, val owner: String? = null, val collection: String? = null, val cursor: String? = null, val limit: Int? = null, val offset: Int? = null)
@Serializable
data class NftAssetsResponse(val previous: String? = null, val assets: List<NftAsset>? = null, val next: String? = null)
@Serializable
data class NftCollection(val safelist_request_status: String? = null, val slug: String? = null, val traits: JsonObject? = null, val banner_image_url: String? = null, val external_link: String? = null, val image_url: String? = null, val payout_address: String? = null, val primary_asset_contracts: List<NftContract>? = null, val editors: List<String>? = null, val name: String? = null, val payment_tokens: List<NftToken>? = null, val seller_fees: String? = null, val stats: JsonObject? = null, val created_at: String? = null, val description: String? = null)
@Serializable
data class NftCollectionRequest(val slug: String? = null)
@Serializable
data class NftCollectionResponse(val collection: NftCollection? = null)
@Serializable
data class NftCollectionsRequest(val limit: Int? = null, val offset: Int? = null, val owner: String? = null)
@Serializable
data class NftCollectionsResponse(val collections: List<NftCollection>? = null)
@Serializable
data class NftContract(val name: String? = null, val owner: Int? = null, val schema: String? = null, val seller_fees: String? = null, val symbol: String? = null, val type: String? = null, val address: String? = null, val description: String? = null, val created_at: String? = null, val payout_address: String? = null)
@Serializable
data class NftCreateRequest(val data: String? = null, val description: String? = null, val image: String? = null, val name: String? = null)
@Serializable
data class NftCreateResponse(val asset: NftAsset? = null)
@Serializable
data class NftSale(val asset_decimals: Int? = null, val payment_token: NftToken? = null, val quantity: String? = null, val total_price: String? = null, val asset_token_id: String? = null, val created_at: String? = null, val event_timestamp: String? = null, val event_type: String? = null, val transaction: NftTransaction? = null)
@Serializable
data class NftToken(val id: Int? = null, val image_url: String? = null, val name: String? = null, val symbol: String? = null, val usd_price: String? = null, val address: String? = null, val decimals: Int? = null, val eth_price: String? = null)
@Serializable
data class NftTransaction(val block_hash: String? = null, val block_number: String? = null, val from_account: NftUser? = null, val id: Int? = null, val timestamp: String? = null, val to_account: NftUser? = null, val transaction_hash: String? = null, val transaction_index: String? = null)
@Serializable
data class NftUser(val address: String? = null, val profile_url: String? = null, val username: String? = null)
