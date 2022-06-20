
package examples.price.list

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.price
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = PricelistRequest(name = "Jone")
  
  try {
      val response = PriceService.list(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
