
package examples.bitcoin.transaction

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.bitcoin

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = BitcoinTransactionRequest(Hash = "f854aebae95150b379cc1187d848d58225f3c4157fe992bcd166f58bd5063449",)
  
  try {
      val response = BitcoinServ.transaction(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
