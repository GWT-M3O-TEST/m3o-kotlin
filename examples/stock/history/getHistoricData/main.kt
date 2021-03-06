
package examples.stock.history

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.stock

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = StockHistoryRequest(Stock = "AAPL",
Date = "2020-10-01",)
  
  try {
      val response = StockServ.history(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
