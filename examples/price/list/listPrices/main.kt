
package examples.price.list

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.price

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = PriceListRequest(Currency = "GBP",)
  
  try {
      val response = PriceServ.list(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
