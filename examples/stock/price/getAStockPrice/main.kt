
package examples.stock.price

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.stock

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = StockPriceRequest(Symbol = "AAPL",)
  
  try {
      val response = StockServ.price(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
