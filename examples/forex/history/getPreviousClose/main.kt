
package examples.forex.history

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.forex

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = ForexHistoryRequest(Symbol = "GBPUSD",)
  
  try {
      val response = ForexServ.history(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
