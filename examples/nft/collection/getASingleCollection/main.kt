
package examples.nft.collection

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.nft

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = NftCollectionRequest(Slug = "doodles-official",)
  
  try {
      val response = NftServ.collection(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
