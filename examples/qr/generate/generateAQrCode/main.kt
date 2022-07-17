
package examples.qr.generate

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.qr

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = QrGenerateRequest(Text = "https://m3o.com/qr",
Size = 300,)
  
  try {
      val response = QrServ.generate(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
