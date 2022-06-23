
package examples.crypto.price

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.crypto

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = CryptoPriceRequest(Symbol = "BTCUSD",)
  
  try {
      val response = CryptoService.price(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
