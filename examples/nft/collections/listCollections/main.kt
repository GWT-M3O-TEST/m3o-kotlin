
package examples.nft.collections

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.nft

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = NftCollectionsRequest(Limit = 1,)
  
  try {
      val response = NftServ.collections(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
