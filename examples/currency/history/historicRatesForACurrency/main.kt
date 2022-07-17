
package examples.currency.history

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.currency

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = CurrencyHistoryRequest(Code = "USD",
Date = "2021-05-30",)
  
  try {
      val response = CurrencyServ.history(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
