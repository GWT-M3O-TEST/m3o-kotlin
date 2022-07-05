
package examples.spam.classify

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.spam

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = SpamClassifyRequest(Subject = "Welcome",
TextBody = "Hi there,\n\nWelcome to M3O.\n\nThanks\nM3O team",
From = "noreply@m3o.com",
To = "hello@example.com",)
  
  try {
      val response = SpamService.classify(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
