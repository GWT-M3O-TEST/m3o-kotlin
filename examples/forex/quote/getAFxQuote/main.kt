
package examples.forex.quote

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.forex
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ForexquoteRequest(name = "Jone")
  
  try {
      val response = ForexService.quote(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
