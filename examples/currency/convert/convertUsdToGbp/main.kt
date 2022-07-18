
package examples.currency.convert

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.currency

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = CurrencyConvertRequest(From = "USD",
To = "GBP",)
  
  try {
      val response = CurrencyServ.convert(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
