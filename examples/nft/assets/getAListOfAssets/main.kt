
package examples.nft.assets

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.nft

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = NftAssetsRequest(OrderBy = "sale_date",
Limit = 1,)
  
  try {
      val response = NftService.assets(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
