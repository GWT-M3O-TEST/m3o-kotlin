
package examples.bitcoin.balance

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.bitcoin

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = BitcoinBalanceRequest(Address = "1MDUoxL1bGvMxhuoDYx6i11ePytECAk9QK",)
  
  try {
      val response = BitcoinServ.balance(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
