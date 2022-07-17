
package examples.user.resetPassword

import com.m3o.m3okotlin.M3O
import com.m3o.m3okotlin.services.user

suspend fun main() {
  M3O.initialize(System.getenv("M3O_API_TOKEN"))

  val req = UserResetPasswordRequest(Email = "joe@example.com",
Code = "012345",)
  
  try {
      val response = UserServ.resetPassword(req)
      println(response)
  } catch (e: Exception) {
      println(e)
  }
}
