
package examples.forex.price

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.forex

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ForexPriceRequest(name = "Jone")
  
  try {
      val response = ForexService.price(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
