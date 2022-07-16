
package examples.user.sendPasswordResetEmail

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.user

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UserSendPasswordResetEmailRequest(Subject = "Password reset",
Email = "joe@example.com",)
  
  try {
      val response = UserService.sendPasswordResetEmail(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
