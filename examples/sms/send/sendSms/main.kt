
package examples.sms.send

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.sms

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SmsSendRequest(To = "+447681129",
From = "Alice",
Message = "Hi there!",)
  
  try {
      val response = SmsService.send(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
