
package examples.user.sendPasswordResetEmail

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.user

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UserSendPasswordResetEmailRequest(Email = "joe@example.com",
Subject = "Password reset",)
  
  try {
      val response = UserServ.sendPasswordResetEmail(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
