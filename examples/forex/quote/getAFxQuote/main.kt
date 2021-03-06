
package examples.forex.quote

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.forex

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ForexQuoteRequest(Symbol = "GBPUSD",)
  
  try {
      val response = ForexServ.quote(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
