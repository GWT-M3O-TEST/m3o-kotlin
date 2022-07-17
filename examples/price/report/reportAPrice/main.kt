
package examples.price.report

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.price

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = PriceReportRequest(Name = "bitcoin",
Symbol = "BTC",
Comment = "Price is not up to date",)
  
  try {
      val response = PriceServ.report(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
