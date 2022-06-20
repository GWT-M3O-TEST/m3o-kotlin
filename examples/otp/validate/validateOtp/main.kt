
package examples.otp.validate

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.otp

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = OtpValidateRequest(name = "Jone")
  
  try {
      val response = OtpService.validate(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
