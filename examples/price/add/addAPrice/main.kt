
package examples.price.add

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.price

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = PriceAddRequest(Price = 39037.97,
Currency = "USD",
Name = "bitcoin",)
  
  try {
      val response = PriceService.add(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
