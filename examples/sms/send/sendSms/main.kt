
package examples.sms.send

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.sms

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SmsSendRequest(Message = "Hi there!",
To = "+447681129",
From = "Alice",)
  
  try {
      val response = SmsServ.send(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
