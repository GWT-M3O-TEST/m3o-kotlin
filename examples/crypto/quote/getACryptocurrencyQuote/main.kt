
package examples.crypto.quote

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.crypto

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = CryptoQuoteRequest(Symbol = "BTCUSD",)
  
  try {
      val response = CryptoServ.quote(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
