
package examples.price.get

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.price

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = PriceGetRequest(Currency = "USD",
Name = "bitcoin",)
  
  try {
      val response = PriceServ.get(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
