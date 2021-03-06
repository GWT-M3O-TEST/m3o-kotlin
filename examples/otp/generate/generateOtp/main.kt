
package examples.otp.generate

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.otp

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = OtpGenerateRequest(Id = "asim@example.com",)
  
  try {
      val response = OtpServ.generate(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
