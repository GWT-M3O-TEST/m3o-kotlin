
package examples.user.sendVerificationEmail

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.user

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UserSendVerificationEmailRequest(Email = "joe@example.com",
Subject = "Email verification",)
  
  try {
      val response = UserService.sendVerificationEmail(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
