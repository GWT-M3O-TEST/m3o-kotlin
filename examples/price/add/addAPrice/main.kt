
package examples.price.add

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.price

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = PriceAddRequest(Name = "bitcoin",
Price = 39037.97,
Currency = "USD",)
  
  try {
      val response = PriceService.add(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
