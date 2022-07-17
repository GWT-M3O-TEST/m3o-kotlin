
package examples.nft.create

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.nft

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = NftCreateRequest(Description = "The epic monkey island character",
Name = "Guybrush Threepwood",)
  
  try {
      val response = NftServ.create(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
