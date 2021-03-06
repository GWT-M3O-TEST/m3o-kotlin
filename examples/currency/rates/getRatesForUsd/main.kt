
package examples.currency.rates

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.currency

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = CurrencyRatesRequest(Code = "USD",)
  
  try {
      val response = CurrencyServ.rates(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
