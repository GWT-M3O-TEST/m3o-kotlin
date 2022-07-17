
package examples.nft.asset

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.nft

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = NftAssetRequest(ContractAddress = "0xb47e3cd837ddf8e4c57f05d70ab865de6e193bbb",
TokenId = "1",)
  
  try {
      val response = NftServ.asset(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
