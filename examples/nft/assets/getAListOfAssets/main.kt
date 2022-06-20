
package examples.nft.assets

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.nft
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = NftassetsRequest(name = "Jone")
  
  try {
      val response = NftService.assets(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}