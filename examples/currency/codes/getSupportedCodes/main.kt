
package examples.currency.codes

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.currency

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = CurrencyCodesRequest()
  
  try {
      val response = CurrencyServ.codes(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
