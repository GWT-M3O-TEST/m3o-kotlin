
package examples.stock.history

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.stock
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = StockhistoryRequest(name = "Jone")
  
  try {
      val response = StockService.history(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}