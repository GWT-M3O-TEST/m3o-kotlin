
package examples.user.verifyEmail

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.user

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UserVerifyEmailRequest(Token = "012345",)
  
  try {
      val response = UserService.verifyEmail(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
