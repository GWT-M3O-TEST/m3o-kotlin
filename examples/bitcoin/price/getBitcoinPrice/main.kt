
package examples.bitcoin.price

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.bitcoin

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = BitcoinPriceRequest(name = "Jone")
  
  try {
      val response = BitcoinService.price(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
