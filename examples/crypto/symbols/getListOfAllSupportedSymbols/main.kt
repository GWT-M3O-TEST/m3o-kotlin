
package examples.crypto.symbols

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.crypto
suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = CryptosymbolsRequest(name = "Jone")
  
  try {
      val response = CryptoService.symbols(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
