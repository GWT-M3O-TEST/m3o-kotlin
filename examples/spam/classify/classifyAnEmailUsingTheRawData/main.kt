
package examples.spam.classify

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.spam

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SpamClassifyRequest(EmailBody = "Subject: Welcome\r\nTo: hello@emaple.com\r\nFrom: noreply@m3o.com\r\n\r\nHi there,\n\nWelcome to M3O.\n\nThanks\nM3O team",)
  
  try {
      val response = SpamServ.classify(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
