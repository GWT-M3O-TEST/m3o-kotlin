
package examples.price.add

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.price
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = PriceaddRequest(name = "Jone")
  
  try {
      val response = PriceService.add(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
