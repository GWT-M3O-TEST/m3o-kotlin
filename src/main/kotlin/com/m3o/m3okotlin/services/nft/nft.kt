
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
internal data class NftAsset({/// the permalink
String? permalink, /// the token id
String? token_id, /// last time sold
Sale? last_sale, /// asset contract
Contract? contract, /// the image url
String? image_url, /// Owner of the NFT
User? owner, /// is it a presale
bool? presale, /// associated collection
Collection? collection, /// traits associated with the item
List<Map<String, dynamic>>? traits, /// Creator of the NFT
User? creator, /// id of the asset
int? id, /// listing date
String? listing_date, /// name of the asset
String? name, /// number of sales
int? sales, /// related description
String? description,})
@Serializable
internal data class NftAssetRequest({String? contract_address, String? token_id,})
@Serializable
data class NftAssetResponse({Asset? asset,})
@Serializable
internal data class NftAssetsRequest({/// order "asc" or "desc"
String? order, /// order by "sale_date", "sale_count", "sale_price", "total_price"
String? order_by, /// limit to members of a collection by slug name (case sensitive)
String? collection, /// A cursor pointing to the page to retrieve
String? cursor, /// limit returned assets
int? limit, /// DEPRECATED offset for pagination, please use cursor instead
int? offset,})
@Serializable
data class NftAssetsResponse({/// A cursor to be supplied to retrieve the previous page of results
String? previous, /// list of assets
List<Asset>? assets, /// A cursor to be supplied to retrieve the next page of results
String? next,})
@Serializable
internal data class NftCollection({/// payout address for the collection's royalties
String? payout_address, /// sales statistics associated with the collection
Map<String, dynamic>? stats, /// listing of all the trait types available within this collection
Map<String, dynamic>? traits, /// description of the collection
String? description, /// an image for the collection
String? image_url, /// name of the collection
String? name, /// a list of the contracts associated with this collection
List<Contract>? primary_asset_contracts, /// approved editors for this collection
List<String>? editors, /// external link to the original website for the collection
String? external_link, /// the payment tokens accepted for this collection
List<Token>? payment_tokens, /// the fees that get paid out when a sale is made
String? seller_fees, /// collection slug
String? slug, /// image used in the banner for the collection
String? banner_image_url, /// the collection's approval status on OpenSea
String? safelist_request_status, /// creation time
String? created_at,})
@Serializable
internal data class NftCollectionRequest({String? slug,})
@Serializable
data class NftCollectionResponse({Collection? collection,})
@Serializable
internal data class NftCollectionsRequest({int? limit, int? offset,})
@Serializable
data class NftCollectionsResponse({List<Collection>? collections,})
@Serializable
internal data class NftContract({/// name of contract
String? name, /// owner id
int? owner, /// aka "ERC1155"
String? schema, /// related symbol
String? symbol, /// ethereum address
String? address, /// timestamp of creation
String? created_at, /// description of contract
String? description, /// payout address
String? payout_address, /// seller fees
String? seller_fees, /// type of contract e.g "semi-fungible"
String? type,})
@Serializable
internal data class NftCreateRequest({/// data if not image
String? data, /// description
String? description, /// image data
String? image, /// name of the NFT
String? name,})
@Serializable
data class NftCreateResponse({Asset? asset,})
@Serializable
internal data class NftSale({String? created_at, String? event_timestamp, Token? payment_token, String? quantity, String? total_price, Transaction? transaction, String? asset_token_id, String? event_type, int? asset_decimals,})
@Serializable
internal data class NftToken({String? address, int? decimals, String? eth_price, int? id, String? image_url, String? name, String? symbol, String? usd_price,})
@Serializable
internal data class NftTransaction({String? block_number, User? from_account, int? id, String? timestamp, User? to_account, String? transaction_hash, String? transaction_index, String? block_hash,})
@Serializable
internal data class NftUser({String? username, String? address, String? profile_url,})
