
package examples.email.send

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.email

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = EmailSendRequest(name = "Jone")
  
  try {
      val response = EmailService.send(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
