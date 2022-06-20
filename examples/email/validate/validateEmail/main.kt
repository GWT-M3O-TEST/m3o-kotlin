
package examples.email.validate

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.email

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = EmailValidateRequest(name = "Jone")
  
  try {
      val response = EmailService.validate(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
